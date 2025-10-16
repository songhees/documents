package com.song.springjpatest.repository.weather;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.song.springjpatest.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class WeatherRepositoryImpl implements WeatherRepository {

    private final JPAQueryFactory jpaQueryFactory;
    QWeather weather = QWeather.weather;
    QRegion region = QRegion.region;

    @Override
    public List<Weather> getWeatherAll() {
        return jpaQueryFactory.selectFrom(weather).fetch();
    }

    @Override
    public List<Weather> getWeatherAllFetch() {
        return jpaQueryFactory.selectFrom(weather).join(weather.weatherId.region, region).fetchJoin().fetch();
    }

    /**
     * toOne fetch join + paging처리
     */
    @Override
    public Page<Weather> findAllPaging(Pageable pageable) {
        List<Weather> result = jpaQueryFactory.selectFrom(weather)
                .leftJoin(weather.weatherId.region, region).fetchJoin()
                .offset(pageable.getOffset()).limit(pageable.getPageSize()).fetch();

        Long total = jpaQueryFactory
                .select(weather.weatherId.count())
                .from(weather)
                .fetchOne();
        return new PageImpl<>(result, pageable, total == null ? 0 : total);
    }

    @Override
    public List<Weather> getWeathersByRegion(Long id) {
        return jpaQueryFactory.selectFrom(weather).where(weather.weatherId.region.id.eq(id)).fetch();
    }

    @Override
    public List<Weather> getWeathersByRegionFetch(Long id) {
        return jpaQueryFactory.selectFrom(weather).join(weather.weatherId.region, region).fetchJoin().where(weather.weatherId.region.id.eq(id)).fetch();
    }

    @Override
    public void updateWeathersFlag(String flag) {
        QcFlag qcFlag = QcFlag.valueOf(flag);
        jpaQueryFactory.update(weather)
                .set(weather.qcFlag, qcFlag).execute();
    }
}
