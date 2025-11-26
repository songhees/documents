package com.batch.spirng_batch.job.dataConfig;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.batch.spirng_batch.entity.QcFlag;
import com.batch.spirng_batch.entity.Weather;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class WeatherConfig {
    
    private static final int chunkSize = 10;
    private final EntityManager entityManager;

    @Bean
    @StepScope
    JpaPagingItemReader<Weather> weatherFlagReader(@Value("#{jobParameters[time]}") String time) {
        String jpql = "select w.* from Weather w where w.qcFlag is null";

        return new JpaPagingItemReaderBuilder<Weather>()
            .name("weatherReader")
            .entityManagerFactory(entityManager.getEntityManagerFactory())
            .queryString(jpql)
            .pageSize(chunkSize)
            .build();
    }

    @Bean
    ItemProcessor<Weather, Weather> weatherFlagProcessor() {
        return weather -> {
            weather.setQcFlag(QcFlag.PASS);
            return weather;
        };    
    }   

    
}
