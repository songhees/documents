package com.song.springjpatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringJpaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaTestApplication.class, args);
    }

}
