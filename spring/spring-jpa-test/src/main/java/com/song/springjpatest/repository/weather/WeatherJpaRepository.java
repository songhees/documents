package com.song.springjpatest.repository.weather;

import com.song.springjpatest.entity.Weather;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// JpaRepository를 확장했으므로 Jpa가 이를 인식함
public interface WeatherJpaRepository extends JpaRepository<Weather, Long>, WeatherRepository {

    @Nonnull
    @Query("select r from Weather r")
    List<Weather> findAll();

    @Nonnull
    @EntityGraph(attributePaths = {"weatherId.region"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("select r from Weather r")
    List<Weather> findAllEntityGraph();
}
