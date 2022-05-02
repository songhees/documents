package org.zerock.task;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.zerock.domain.BoardAttachVO;
import org.zerock.mapper.BoardAttachVOMapper;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Log4j
@Component
public class FileCheckTask {

    @Setter(onMethod_ = @Autowired)
    private BoardAttachVOMapper mapper;

    private String getFolderYesterDay() {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DATE, -1);

        String str = sd.format(cal.getTime());
        return str.replace("-", File.separator);
    }

//    @Scheduled(cron = "0 * * * * *")
    public void checkFiles()throws Exception {
        log.warn("File Check Task run.,.");
        log.warn("===============");

        List<BoardAttachVO> list = mapper.getOldFiles();

        List<Path> fileListPaths = list.stream()
                .map(vo -> Paths.get("/Users/songhee/upload", vo.getUploadPath(), vo.getUuid() + "_" + vo.getFileName()))
                .collect(Collectors.toList());

        // 섬내일 path값 추가하기
        list.stream().filter(vo -> vo.isFileType() == true)
                .map(vo -> Paths.get("/Users/songhee/upload", vo.getUploadPath(), "s_" + vo.getUuid() + "_" + vo.getFileName()))
                .forEach(p -> fileListPaths.add(p));

        fileListPaths.forEach(path -> log.info(path));

        File targetDir = Paths.get("/Users/songhee/upload", getFolderYesterDay()).toFile();

        File[] removeFiles = targetDir.listFiles(file -> fileListPaths.contains(file.toPath()) == false);

        for (File file : removeFiles) {
            file.delete();
        }
    }
}
