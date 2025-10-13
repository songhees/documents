package com.song.springjpatest;


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
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
class JpaRepositoryTest {

    @Autowired
    private WeatherJpaRepository weatherRepository;
    @Autowired
    private RegionJpaRepository bookRepository;

    @PersistenceContext
    private EntityManager em;


    @Test
    @DisplayName("Update 테스트")
    void testJpaRepository() {
        weatherRepository.updateWeathersFlag("PASS");

        List<Weather> beforeResult = weatherRepository.findAll();

        assertThat(beforeResult).isNotEmpty();
        em.clear();

        List<Weather> afterResult = weatherRepository.findAll();

        assertThat(afterResult).isEqualTo(beforeResult);
    }

//    @Test
//    @DisplayName("N:1 에러 테스트 all")
//    void testJpaRepository() {
//        Region region = Region.builder().name("book1")
//                .build();
//
//        bookRepository.save(region);
//
//
//        Weather weather = Weather.builder().region(region).build();
//        Weather weather2 = Weather.builder().region(region).build();
//
//        weatherRepository.save(weather);
//        weatherRepository.save(weather2);
//
//        em.flush();
//        em.clear();
//
//        List<Weather> result = weatherRepository.findAll();
//
//        String test = result.stream().map(weather1 -> weather1.getRegion().getTitle()).collect(Collectors.joining(", "));
//        log.info(test);
//        assertThat(result).isNotEmpty();
//    }
//
//    @Test
//    @DisplayName("N:1 에러 테스트 all/fetch")
//    void testJpaFetchRepository() {
//        Region region = Region.builder().title("book1")
//                .build();
//        bookRepository.save(region);
//
//        Weather weather = Weather.builder().region(region).build();
//        Weather weather2 = Weather.builder().region(region).build();
//
//        weatherRepository.save(weather);
//        weatherRepository.save(weather2);
//
//        em.flush();
//        em.clear();
//
//        List<Weather> result = weatherRepository.findFetchAll();
//
//        String test = result.stream().map(weather1 -> weather1.getRegion().getTitle()).collect(Collectors.joining(", "));
//        log.info(test);
//        assertThat(result).isNotEmpty();
//    }
//
//    @Test
//    @DisplayName("N:1 에러 테스트 detail")
//    void testJpaDetailRepository() {
//        Region region = Region.builder().title("book1")
//                .build();
//
//        bookRepository.save(region);
//
//        Weather weather = Weather.builder().region(region).build();
//
//        weatherRepository.save(weather);
//
//        em.flush();
//        em.clear();
//
//        Weather result = weatherRepository.findAllAndBook(1L);
//
//        log.info(result.getRegion().getTitle());
//        assertThat(result).isNotNull();
//    }
}
