package org.song.springwebsocket.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.song.springwebsocket.domain.FileVO;
import org.song.springwebsocket.repository.CommonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommonService {
    private final CommonRepository commonRepository;

    @PostConstruct
    public void init() {
        List<FileVO> fileVOS = new ArrayList<>();
        fileVOS.add(FileVO.builder().popupNm("TestPop1").url("https://www.naver.com")
                .build());
        fileVOS.add(FileVO.builder().popupNm("TestPop2").url("https://www.google.com")
                .build());
        commonRepository.saveAll(fileVOS);
    }

    public List<FileVO> getFileVOList(){
        return commonRepository.findAll();
    }

    public FileVO getFileInfo(Long fileId){
        Optional<FileVO> result = commonRepository.findById(fileId);
        return result.orElseGet(() -> FileVO.builder().url("https://www.naver.com").build());
    }
}
