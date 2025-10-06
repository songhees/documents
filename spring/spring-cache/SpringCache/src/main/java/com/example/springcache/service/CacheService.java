package com.example.springcache.service;

import com.example.springcache.domain.SimpleVO;
import com.example.springcache.mapper.CacheMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CacheService {
    private final CacheMapper mapper;

    @Cacheable(sync = true, value = "test", key = "'test'")
    public List<SimpleVO> getAllSimpleVO() {
        List<SimpleVO> list = mapper.getAllSimpleVO();
        return list;
    }

    @CachePut(value = "test", key = "'test'")
    public List<SimpleVO> modifySimpleVO(SimpleVO simpleVO) {
        List<SimpleVO> list = mapper.modifySimpleVO(simpleVO);
        return list;
    }
}
