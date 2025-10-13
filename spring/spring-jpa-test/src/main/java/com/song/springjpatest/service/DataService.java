package com.song.springjpatest.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.postgresql.PGConnection;
import org.postgresql.copy.CopyManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;

@Component
@RequiredArgsConstructor
public class DataService {

    @Value("${file.local}")
    private String importPath;

    private final DataSource dataSource;

//    @PostConstruct
    @Transactional
    public long copyWeatherCsv() throws Exception {
        Path path = Paths.get(importPath + "OBS_ASOS_TIM_20251013202420_utf8.csv");
        try (Connection con = DataSourceUtils.getConnection(dataSource)) {

            PGConnection pgCon = con.unwrap(PGConnection.class);
            CopyManager cm = pgCon.getCopyAPI();

            // CSV 헤더가 있다면 HEADER true
            String sql = """
                COPY tb_weather(region_id, "time", temperature)
                FROM STDIN WITH (FORMAT csv, HEADER true, DELIMITER ',', QUOTE '"')
            """;

            try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
                con.setAutoCommit(false);
                try (reader) {
                    long rows = cm.copyIn(sql, reader);
                    con.commit();
                    return rows;
                } catch (Exception e) {
                    con.rollback();
                    throw e;
                } finally {
                    con.setAutoCommit(true);
                }
            }
        }
    }
}
