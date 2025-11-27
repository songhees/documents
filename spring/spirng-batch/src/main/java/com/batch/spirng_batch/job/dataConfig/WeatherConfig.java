package com.batch.spirng_batch.job.dataConfig;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.MethodInvokingTaskletAdapter;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
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
    private final DataSource dataSource;

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

    @Bean
    ItemWriter<Weather> weatherFlagWriter() {
        String sql = """
            update tb_weather set qc_flag = :qcFlag 
            where region_id = :weatherId.region.id and time = :weatherId.time 
            """;
        return new JdbcBatchItemWriterBuilder<Weather>()
                .dataSource(dataSource)
                .sql(sql)
                .beanMapped()
                .build();
    }
}
