package com.batch.spirng_batch.job;

import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BatchJob {
    
    private final JobBuilder jobBuilder;

    @Bean
    public Job updateWeather() throws Exception {
        return null;
    }

}
