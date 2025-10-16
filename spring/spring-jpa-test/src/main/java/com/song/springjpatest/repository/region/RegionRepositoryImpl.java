package com.song.springjpatest.repository.region;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.song.springjpatest.entity.QRegion;
import com.song.springjpatest.entity.QWeather;
import com.song.springjpatest.entity.Region;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RegionRepositoryImpl implements RegionRepository {
    QRegion qRegion = QRegion.region;
    QWeather qWeather = QWeather.weather;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Region> findAllFetch() {
        return jpaQueryFactory.selectFrom(qRegion).leftJoin(qRegion.weathers, qWeather).fetchJoin().fetch();
    }

    @Override
    public Long updateRegion(Long id, Integer count) {
        return jpaQueryFactory.update(qRegion).set(qRegion.count, count)
                .where(qRegion.id.eq(id)).execute();
    }

    /**
     * toMany fetch join + paging처리
     */
    @Override
    public Page<Region> findAllPaging(Pageable pageable) {
        List<Region> result = jpaQueryFactory.selectFrom(qRegion)
                .leftJoin(qRegion.weathers, qWeather).fetchJoin()
                .offset(pageable.getOffset()).limit(pageable.getPageSize()).fetch();

        Long total = jpaQueryFactory
                .select(qRegion.id.count())
                .from(qRegion)
                .fetchOne();
        return new PageImpl<>(result, pageable, total == null ? 0 : total);
    }


}
