package org.zerock.controller;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.AttachFileDTO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@Log4j
public class UploadController {

    @GetMapping("/uploadForm")
    public void uploadForm() {
        log.info("upload form");
    }

    // html
    @PostMapping("/uploadFormAction")
    public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
        String uploadFolder = "/Users/songhee/upload";
        for (MultipartFile multipartFile : uploadFile) {
            log.info("----------------");
            log.info("UploadFileName: " + multipartFile.getOriginalFilename());
            log.info("UploadName: " + multipartFile.getName());
            log.info("UploadFileSize " + multipartFile.getSize());

            File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());

            try {
                multipartFile.transferTo(saveFile);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    @GetMapping("/uploadAjax")
    public void uploadAjax() {
        log.info("upload ajax");
    }

    @PostMapping(value ="/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {
        List<AttachFileDTO> list = new ArrayList<>();
        String uploadFolder = "/Users/songhee/upload";

        String uploadFolderPath = getFolder();
        // make folder
        File uploadPath = new File(uploadFolder, uploadFolderPath);
        log.info("upload path: " + uploadPath);

        if (uploadPath.exists() == false) {
            uploadPath.mkdirs();
        }

        // upload files
        for (MultipartFile multipartFile : uploadFile) {
            log.info("----------------");
            log.info("UploadFileName: " + multipartFile.getOriginalFilename());
            log.info("UploadFileSize " + multipartFile.getSize());

            AttachFileDTO attachDTO = new AttachFileDTO();

            String uploadFileName = multipartFile.getOriginalFilename();

            uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
            attachDTO.setFileName(uploadFileName);

            UUID uuid = UUID.randomUUID();
            uploadFileName = uuid.toString() + "_" + uploadFileName;

            log.info("only file name: " + uploadFileName);

            try {
                File saveFile = new File(uploadPath, uploadFileName);
                multipartFile.transferTo(saveFile);
                attachDTO.setUuid(uuid.toString());
                attachDTO.setUploadPath(uploadFolderPath);
                // check image type
                if (checkImageType(saveFile)) {
                    attachDTO.setImage(true);
                    FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));

                    Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);

                    thumbnail.close();
                }
                list.add(attachDTO);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/display")
    public ResponseEntity<byte[]> getFile(String fileName) {
        log.info("fileName: " + fileName);

        File file = new File("/Users/songhee/upload/" + fileName);

        log.info("file: " + file);

        ResponseEntity<byte[]> result = null;

        try {
            HttpHeaders header = new HttpHeaders();

            header.add("Content-Type", Files.probeContentType(file.toPath()));
            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value="/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(String fileName) {
        log.info("downloadFile: " + fileName);

        Resource resource = new FileSystemResource("/Users/songhee/upload/" + fileName);

        log.info("resource" + resource);

        String resourceName = resource.getFilename();

        // remove UUID
        String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);

        HttpHeaders headers = new HttpHeaders();

        try {
            headers.add("Content-Disposition", "attachment; filename=" + new String(resourceOriginalName.getBytes(StandardCharsets.UTF_8), "ISO-8859-1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

    @PostMapping("deleteFile")
    @ResponseBody
    public ResponseEntity<String> deleteFile(String fileName, String type) {
        File file;

        try {
            file = new File("/Users/songhee/upload/" + URLDecoder.decode(fileName, "UTF-8"));
            file.delete();

            if (type.equals("image")) {
                String largeFileName = file.getAbsolutePath().replace("s_", "");
                file = new File(largeFileName);
                file.delete();
            }
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    private String getFolder() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();

        String str = sdf.format(date);
        return str.replace("-", File.separator);
    }

    private boolean checkImageType(File file) {

        try {
            String contentType = Files.probeContentType(file.toPath());
            return contentType.startsWith("image");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
