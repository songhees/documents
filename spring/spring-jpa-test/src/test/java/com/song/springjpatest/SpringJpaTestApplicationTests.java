package com.song.springjpatest;

import com.song.springjpatest.config.JpaTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(JpaTestConfig.class)
class SpringJpaTestApplicationTests {

    @Test
    void contextLoads() {
    }

}
