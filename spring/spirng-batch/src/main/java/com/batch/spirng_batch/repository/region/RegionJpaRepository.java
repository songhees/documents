package com.batch.spirng_batch.repository.region;

import com.batch.spirng_batch.entity.Region;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Modifying
    @Query(value = """
        update tb_region r 
        set count = o.count
        from (
            select count(w.region_id) as count, w.region_id
            from tb_weather w
            where w.qc_flag = 'PASS'
            group by w.region_id
        ) o
        where r.id = o.region_id
    """, nativeQuery = true)
    void updateRegionCount();
}
