package com.song.springjpatest.repository.region;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.song.springjpatest.entity.QRegion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RegionRepositoryImpl implements RegionRepository {
    QRegion qRegion = QRegion.region;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Long updateRegion(Long id, Integer count) {
        return jpaQueryFactory.update(qRegion).set(qRegion.count, count)
                .where(qRegion.id.eq(id)).execute();
    }
}
