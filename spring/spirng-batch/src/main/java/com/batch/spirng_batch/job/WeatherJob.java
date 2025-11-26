package com.batch.spirng_batch.job;

import java.time.LocalDateTime;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.PlatformTransactionManager;

import com.batch.spirng_batch.entity.Region;
import com.batch.spirng_batch.entity.Weather;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class WeatherJob {
    
    private final JobLauncher jobLauncher;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    // validateWeatherStep (chunk 기반)
    // reader: weather 에서 qc_flag IS NULL 인 데이터 읽기
    // processor: 온도 범위에 따라 qc_flag 값 계산
    // writer: weather 테이블에 qc_flag 업데이트
    // updateRegionCountStep (tasklet 기반)
    // 각 지역별로 weather row 개수를 세어서 region.count 컬럼 업데이트
    @Scheduled(cron = "0 0/5 * * * *")
    public void updateRegionStepJob(Job updateWeather) throws Exception {
        JobParameters jobParameter = new JobParametersBuilder()
                    .addString("time", LocalDateTime.now().toString()).toJobParameters();
        jobLauncher.run(updateWeather, jobParameter);
    }

    @Bean
    Job updateWeather(Step validateWeahterStep, Step updateRegionCounStep) throws Exception {
        return new JobBuilder("updateWeather", jobRepository)
            .start(validateWeahterStep)
            .next(updateRegionCounStep)
            .build();
    }

    @Bean
    Step validateWeahterStep(JpaPagingItemReader<Weather> weatherReader,
         ItemProcessor<Weather, Weather> weatherFlagProcessor) {
        return new StepBuilder("validateWeahterStep", jobRepository)
                    .<Weather, Weather>chunk(10, transactionManager)
                    .reader(weatherReader)
                    .processor(weatherFlagProcessor)
                    .build();
    }

    @Bean
    Step updateRegionCounStep() {
        return new StepBuilder("updateRegionCounStep", jobRepository)
                .<Weather, Region>chunk(10, transactionManager)
                .build();
    }
}
