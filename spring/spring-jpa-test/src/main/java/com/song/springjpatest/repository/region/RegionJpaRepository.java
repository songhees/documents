package com.song.springjpatest.repository.region;

import com.song.springjpatest.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionJpaRepository extends JpaRepository<Region, Long>, RegionRepository {

}
