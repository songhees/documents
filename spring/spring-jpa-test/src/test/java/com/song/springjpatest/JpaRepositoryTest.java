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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(JpaTestConfig.class)
class JpaRepositoryTest {

    @Autowired
    private WeatherJpaRepository weatherRepository;
    @Autowired
    private RegionJpaRepository regionJpaRepository;

    @PersistenceContext
    private EntityManager em;

    @Test
    @DisplayName("벌크 Update 테스트")
    void testJpaUpdateRepository() {
        // 영속성 컨텍스트에 managed
        weatherRepository.findAll();
        weatherRepository.updateWeathersFlag("PASS");

        // db로 바로 update 되므로 영속성 컨텍스트에 업데이트 되지 않음
        List<Weather> beforeResult = weatherRepository.findAll();

        assertThat(beforeResult).isNotEmpty();

        em.clear();

        // clear 됐으므로 db에서 영속성 컨텍스트로 업데이트된 data가 managed됨
        List<Weather> afterResult = weatherRepository.findAll();

        log.info(String.valueOf(beforeResult.get(0).getQcFlag()));
        log.info(String.valueOf(afterResult.get(0).getQcFlag()));
    }

    @Test
    @DisplayName("N:1 에러 테스트 all")
    void testJpaRepository() {
        List<Weather> result = weatherRepository.getWeatherAll();

        assertThat(result).isNotNull();
        for (int i=0; i<result.size()-1; i++) {
            if (!result.get(i).getWeatherId().region().getId().equals(
            result.get(i+1).getWeatherId().region().getId())) {
                log.info(result.get(i).getWeatherId().region().toString());
            }
        }
    }

    @Test
    @DisplayName("N:1 에러 테스트 all/fetch")
    void testFetchJpaRepository() {
        List<Weather> result = weatherRepository.getWeatherAllFetch();

        assertThat(result).isNotNull();

        for (int i=0; i<3; i++) {
            log.info(result.get(i).getWeatherId().region().toString());
        }
    }

    @Test
    @DisplayName("N:1 에러 테스트 detail")
    void testJpaDetailRepository() {
        List<Weather> result = weatherRepository.getWeathersByRegion(90L);

        assertThat(result).isNotNull();

        log.info(result.get(0).getWeatherId().region().toString());
    }

    @Test
    @DisplayName("N:1 에러 테스트 detail/fetch")
    void testJpaFetchDetailRepository() {
        List<Weather> result = weatherRepository.getWeathersByRegionFetch(90L);

        assertThat(result).isNotEmpty();

        log.info(result.get(0).getWeatherId().region().toString());
    }

    @Test
    @DisplayName("toMany를 fetch join시 중복 row 확인")
    void testJpaFetchJoinInOneToMany() {
        List<Region> result = regionJpaRepository.findAll();
        assertThat(result).isNotEmpty();

        List<Region> resultFetch = regionJpaRepository.findAllFetch();
        assertThat(resultFetch).isNotEmpty();

        result.forEach(region -> { log.info(region.toString());});
        log.info("restult size : {}", result.size());
        log.info("fetch join in OneToMany test");
        log.info("restultFetch size : {}", resultFetch.size());
        resultFetch.forEach(region -> { log.info(region.toString());});
    }

    @Test
    @DisplayName("N:1 에러 테스트 all + @BatchSize")
    void testBatchSizeRepository() {
        List<Region> regions = regionJpaRepository.findAll();

        assertThat(regions).isNotNull();

        // id 하나만 조회해도 BatchSize 만큼 조회됨
        regions.get(0).getWeathers().forEach(
                weather -> {
                    log.info(weather.toString());
                });

        List<Weather> result = weatherRepository.findAll();

        assertThat(result).isNotEmpty();
        log.info(result.get(0).getWeatherId().region().toString());
    }

    @Test
    @DisplayName("N:1 에러 테스트 all + @EntityGraph ToOne")
    void entityGraphToOneRepository() {
        List<Weather> target = weatherRepository.findAllEntityGraph();
        assertThat(target).isNotEmpty();
    }

    @Test
    @DisplayName("N:1 에러 테스트 all + @EntityGraph toMany")
    void entityGraphToManyRepository() {
        List<Region> target = regionJpaRepository.findEntityGraphAll();
        assertThat(target).isNotEmpty();
    }
}
