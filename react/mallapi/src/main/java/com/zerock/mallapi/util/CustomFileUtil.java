package com.zerock.mallapi.util;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Log4j2
@RequiredArgsConstructor
public class CustomFileUtil {
    @Value("${org.zerock.upload.path}")
    private String uploadPath;

    @PostConstruct
    public void init() {
        // 해당 경로(폴더)가 존재하는지 확인
        File tempFolder = new File(uploadPath);

        if(tempFolder.exists() == false) {
            // 폴더가 없으면 생성
            tempFolder.mkdir();
        }

        uploadPath = tempFolder.getAbsolutePath();

        log.info("-------------------------------------");
        log.info(uploadPath);
    }

    public List<String> saveFiles(List<MultipartFile> files)throws RuntimeException{
        if(files == null || files.size() == 0){
            return null;
        }
        // 저장된 파일 이름을 저장하기 위한 문자열 리스트
        List<String> uploadNames = new ArrayList<>();

        for (MultipartFile multipartFile : files) {
            // 한글 파일이나 기타 오류를 일으키는 파일 이름으로 인해 UUID
            String savedName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();
            // 저장할 파일의 경로 생성
            Path savePath = Paths.get(uploadPath, savedName);

            try {
                // 가져온 파일을 savePath 경로로 복사
                Files.copy(multipartFile.getInputStream(), savePath);

                String contentType = multipartFile.getContentType();
                //이미지여부 확인
                if(contentType != null && contentType.startsWith("image")){
                    // 썸네일 파일 저장 로직
                    Path thumbnailPath = Paths.get(uploadPath, "s_"+savedName);

                    Thumbnails.of(savePath.toFile())
                            .size(400,400)
                            .toFile(thumbnailPath.toFile());
                }

                uploadNames.add(savedName);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }//end for
        return uploadNames;
    }

    public ResponseEntity<Resource> getFile(String fileName) {
        // 경로의 파일 리소스를 가져옴
        Resource resource = new FileSystemResource(uploadPath+ File.separator + fileName);

        if(!resource.exists()) {
            // 썸네일 기본값
            resource = new FileSystemResource(uploadPath+ File.separator + "default.jpeg");

        }

        HttpHeaders headers = new HttpHeaders();

        try{
            // header 지정 mine type으로 Content-Type 지정 필수
            headers.add("Content-Type", Files.probeContentType( resource.getFile().toPath() ));
        } catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().headers(headers).body(resource);
    }

    public void deleteFiles(List<String> fileNames) {
        if(fileNames == null || fileNames.size() == 0){
            return;
        }

        fileNames.forEach(fileName -> {
            //썸네일이 있는지 확인하고 삭제
            String thumbnailFileName = "s_" + fileName;
            Path thumbnailPath = Paths.get(uploadPath, thumbnailFileName);
            Path filePath = Paths.get(uploadPath, fileName);

            try {
                Files.deleteIfExists(filePath);
                Files.deleteIfExists(thumbnailPath);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        });
    }
}
