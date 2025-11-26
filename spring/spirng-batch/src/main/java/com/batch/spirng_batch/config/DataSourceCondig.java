package com.batch.spirng_batch.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;

@Configuration
public class DataSourceCondig {
    @Bean
    @ConfigurationProperties("batch.datasource")
    DataSource batchDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("batchTransactionManager")
    TransactionManager transactionManager() {
        PlatformTransactionManager transactionManager = new JpaTransactionManager();
        return transactionManager;
    }
}
