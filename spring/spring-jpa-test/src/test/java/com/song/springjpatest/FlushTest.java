package com.song.springjpatest;

import com.song.springjpatest.config.JpaTestConfig;
import com.song.springjpatest.entity.Region;
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

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(JpaTestConfig.class)
class FlushTest {
    @Autowired
    private WeatherJpaRepository weatherRepository;
    @Autowired
    private RegionJpaRepository regionJpaRepository;

    @PersistenceContext
    private EntityManager em;

    @Test
    @DisplayName("JpaRepository flush 테스트")
    void testJpaUpdateRepository() {
        // 테스트 용 엔티티 생성
        Region saved = regionJpaRepository.save(new Region(297L, "test", null, 0));
        em.flush();
        em.clear();

        // 영속성 컨텍스트에 update
        Region newRegion = regionJpaRepository.save(
                new Region(saved.getId(), saved.getName(), saved.getVersion(), saved.getCount()+1));

        log.info("count : {}", newRegion.getCount());

        // 영속성 컨텍스트에 이미 있으므로 값이 같음
        Optional<Region> target = regionJpaRepository.findById(newRegion.getId());
        assertThat(target).isPresent();
        log.info("count : {}", target.get().getCount());

        // 영속성 컨텍스트 초기화
        em.clear();

        // 직접 db에서 데이터 가져옴 -> flush가 안됐으므로 update 전 값이 들어옴
        target = regionJpaRepository.findById(newRegion.getId());
        assertThat(target).isPresent();
        log.info("count : {}", target.get().getCount());
    }

    @Test
    @DisplayName("JpaRepository flush 테스트")
    void testBulkUpdateRepository() {
        Optional<Region> target = regionJpaRepository.findById(90L);
        assertThat(target).isPresent();

        // 기존 값 조회
        log.info("count : {}", target.get().getCount());

        // Querydsl update 실행 후 DB에 반영
        Long updated = regionJpaRepository.updateRegion(90L, 19);
        assertThat(updated).isEqualTo(1L);

        // 영속성 컨텍스트에 update에 반영이 안되어 위의 값과 동일
        log.info("count : {}", target.get().getCount());

        em.clear();
        Optional<Region> afterRegion = regionJpaRepository.findById(90L);
        assertThat(afterRegion).isPresent();

        // clear 후 변경된 값 조회
        log.info("count : {}", afterRegion.get().getCount());
    }
}
