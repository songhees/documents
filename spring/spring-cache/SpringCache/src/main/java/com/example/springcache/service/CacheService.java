package com.example.springcache.service;

import com.example.springcache.domain.SimpleVO;
import com.example.springcache.mapper.CacheMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@CacheConfig(value = "test")
public class CacheService {
    private final CacheMapper mapper;

    @Cacheable(sync = true, key = "'test'")
    public List<SimpleVO> getAllSimpleVO() {
        return mapper.getAllSimpleVO();
    }

    @Transactional
    @CachePut(key = "'test'")
    public List<SimpleVO> modifySimpleVO(SimpleVO simpleVO) {
        List<SimpleVO> list = mapper.modifySimpleVO(simpleVO);
        return list;
    }

    @Transactional
    @CacheEvict(allEntries = true)
    public void removeSimpleVO(SimpleVO simpleVO, CountDownLatch ready, CountDownLatch beforeCommitBlocker) {
        mapper.modifySimpleVO(simpleVO);

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override public void beforeCommit(boolean readOnly) {
                ready.countDown();
                try { beforeCommitBlocker.await(5, TimeUnit.SECONDS); } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
    }
}
