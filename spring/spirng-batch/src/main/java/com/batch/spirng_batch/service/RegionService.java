package com.batch.spirng_batch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.batch.spirng_batch.repository.region.RegionJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class RegionService {
    private final RegionJpaRepository regionJpaRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateRegionCount() {
        regionJpaRepository.updateRegionCount();
    }
}
