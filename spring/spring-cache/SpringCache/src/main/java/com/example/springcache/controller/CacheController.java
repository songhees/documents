package com.example.springcache.controller;

import com.example.springcache.domain.SimpleVO;
import com.example.springcache.service.CacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CacheController {
    private final CacheService service;

    @GetMapping("/search")
    public ResponseEntity<List<SimpleVO>> searchCache() {
        return ResponseEntity.ok(service.getAllSimpleVO());
    }

    @PostMapping("/put")
    public ResponseEntity<Map<String,String>> putCache(@RequestBody SimpleVO simpleVO) {
        log.info(simpleVO.toString());
        service.modifySimpleVO(simpleVO);
        return ResponseEntity.ok(Map.of("port", System.getProperty("local.server.port", "?")));
    }
}
