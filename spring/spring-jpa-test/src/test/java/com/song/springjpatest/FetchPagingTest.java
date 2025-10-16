package com.song.springjpatest;

import com.song.springjpatest.config.JpaTestConfig;
import com.song.springjpatest.entity.Region;
import com.song.springjpatest.entity.Weather;
import com.song.springjpatest.repository.region.RegionJpaRepository;
import com.song.springjpatest.repository.weather.WeatherJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(JpaTestConfig.class)
public class FetchPagingTest {

    @Autowired
    private WeatherJpaRepository weatherRepository;
    @Autowired
    private RegionJpaRepository regionRepository;

    @PersistenceContext
    private EntityManager em;

    @Test
    @DisplayName("toMany에서 fetch join 페이징 처리 테스트")
    void regionFetchPagingTest() {
        Pageable pageable = PageRequest.of(1,10, Sort.by("id").descending());

        // sql 에 limit offest이 보이지 않음, 메모리에서 처리
        Page<Region> regions= regionRepository.findAllPaging(pageable);
        assertThat(regions).isNotEmpty();

        log.info("regions : {}", regions.getContent());
        log.info("regions hasNext : {}", regions.hasNext());
        log.info("regions hasPrevious : {}", regions.hasPrevious());
    }

    @Test
    @DisplayName("toOne에서 fetch join 페이징 처리 테스트")
    void weatherFetchPagingTest() {
        Pageable pageable = PageRequest.of(1,10, Sort.by("weatherId").descending());

        Page<Weather> regions= weatherRepository.findAllPaging(pageable);
        assertThat(regions).isNotEmpty();

        log.info("weathers : {}", regions.getContent());
        log.info("weathers hasNext : {}", regions.hasNext());
        log.info("weathers hasPrevious : {}", regions.hasPrevious());
    }
}
