package com.batch.spirng_batch.job.dataConfig;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.TransientDataAccessException;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import com.batch.spirng_batch.service.RegionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class RegionDataConfig {
    private final RegionService regionService;

    @Bean
    RetryTemplate regionRetryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();

        Map<Class<? extends Throwable>, Boolean> retryable = new HashMap<>();
        retryable.put(TransientDataAccessException.class, true);

        SimpleRetryPolicy retryPolicy =
                new SimpleRetryPolicy(3, retryable, true);

        ExponentialBackOffPolicy backoff = new ExponentialBackOffPolicy();
        backoff.setInitialInterval(500L);  
        backoff.setMultiplier(2.0);         
        backoff.setMaxInterval(5_000L);     

        retryTemplate.setRetryPolicy(retryPolicy);
        retryTemplate.setBackOffPolicy(backoff);

        return retryTemplate;
    }

    @Bean
    Tasklet regionUpdateTasklet(RetryTemplate regionRetryTemplate) {
        return (contribution, chunkContext) -> {     
            regionRetryTemplate.execute(context -> {
                regionService.updateRegionCount();
                return null;
            });
            return RepeatStatus.FINISHED;
        };
    }
}
