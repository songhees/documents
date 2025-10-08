package com.example.springcache;

import com.example.springcache.domain.SimpleVO;
import com.example.springcache.service.CacheService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringCacheApplicationTests {
    @Autowired
    CacheManager cacheManager;
    @Autowired
    CacheService cacheService;

    @Test
    void contextLoads() throws InterruptedException {
        cacheManager.getCache("test").clear();
        System.out.println(cacheManager.getClass());

        var beforeCommitBlocker = new CountDownLatch(1);
        var ready = new CountDownLatch(1);

        var writer = new Thread(() -> cacheService.removeSimpleVO(SimpleVO.builder()
                .id(1).validation("N").build(), ready, beforeCommitBlocker));
        // 스레드 시작
        writer.start();

        Assertions.assertTrue(ready.await(5, TimeUnit.SECONDS));

        // 다른 스레드에서 조회
        List<SimpleVO> v1 = cacheService.getAllSimpleVO();

        // 커밋 진행
        beforeCommitBlocker.countDown();
        writer.join(2000);

        List<SimpleVO> cached  = cacheService.getAllSimpleVO(); // 캐시 히트
        System.out.println(v1.toString());
        System.out.println(cached.toString());
    }
}
