package com.example.springcache.config;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.transaction.TransactionAwareCacheManagerProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableCaching(order = 2)
@RequiredArgsConstructor
public class CacheConfig {

    @Bean(name = "delegateCacheManager")
    public CacheManager delegateCacheManager(HazelcastInstance hz) {
        return new HazelcastCacheManager(hz);
    }

    @Bean
    @Primary
    public CacheManager transactionAwareCacheManager(
            @Qualifier("delegateCacheManager") CacheManager target) {
        return new TransactionAwareCacheManagerProxy(target);
    }
}
