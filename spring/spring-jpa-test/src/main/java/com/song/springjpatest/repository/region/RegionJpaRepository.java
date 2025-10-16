package com.song.springjpatest.repository.region;

import com.song.springjpatest.entity.Region;
import com.song.springjpatest.entity.Weather;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegionJpaRepository extends JpaRepository<Region, Long>, RegionRepository {
    @Nonnull
    @Query("select r, r.weathers from Region r")
    List<Region> findAll();

    @Nonnull
    @EntityGraph(attributePaths = "weathers", type = EntityGraph.EntityGraphType.FETCH)
    @Query("select r from Region r")
    List<Region> findEntityGraphAll();
}
