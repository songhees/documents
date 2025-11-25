package com.batch.spirng_batch.repository.region;

import com.batch.spirng_batch.entity.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RegionRepository {
    List<Region> findAllFetch();

    Long updateRegion(Long id, Integer count);

    Page<Region> findAllPaging(Pageable pageable);
}
