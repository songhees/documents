package com.example.springcache.mapper;

import com.example.springcache.domain.SimpleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CacheMapper {
    List<SimpleVO> getAllSimpleVO();

    List<SimpleVO> modifySimpleVO(SimpleVO simpleVO);
}
