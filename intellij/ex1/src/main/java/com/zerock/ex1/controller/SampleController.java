package com.zerock.ex1.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Log4j
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/hello")
    public @ResponseBody String[] hello() {
        return new String[]{"Hello", "World"};
    }
}
