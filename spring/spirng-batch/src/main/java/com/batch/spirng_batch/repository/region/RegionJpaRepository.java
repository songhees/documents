package com.batch.spirng_batch.repository.region;

import com.batch.spirng_batch.entity.Region;
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
