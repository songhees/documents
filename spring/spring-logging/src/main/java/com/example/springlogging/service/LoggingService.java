package com.example.springlogging.service;

import com.example.springlogging.domain.SimpleVO;
import com.example.springlogging.mapper.LoggingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoggingService {
    private final LoggingMapper mapper;

    public List<SimpleVO> getAllSimpleVO() {
        List<SimpleVO> list = mapper.getAllSimpleVO();
        return list;
    }

    public List<SimpleVO> modifySimpleVO(SimpleVO simpleVO) {
        List<SimpleVO> list = mapper.modifySimpleVO(simpleVO);
        return list;
    }
}
