package com.example.springlogging.controller;

import com.example.springlogging.domain.SimpleVO;
import com.example.springlogging.service.LoggingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoggingController {
    private final LoggingService service;

    @GetMapping("/search")
    public ResponseEntity<List<SimpleVO>> searchCache() {
        return ResponseEntity.ok(service.getAllSimpleVO());
    }

    @PostMapping("/put")
    public ResponseEntity<String> putCache(@RequestBody SimpleVO simpleVO) {
        log.info(simpleVO.toString());
        service.modifySimpleVO(simpleVO);
        return ResponseEntity.ok("success");
    }
}
