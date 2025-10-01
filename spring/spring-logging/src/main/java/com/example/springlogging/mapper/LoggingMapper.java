package com.example.springlogging.mapper;

import com.example.springlogging.domain.SimpleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoggingMapper {
    List<SimpleVO> getAllSimpleVO();

    List<SimpleVO> modifySimpleVO(SimpleVO simpleVO);
}
