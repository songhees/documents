package com.song.springjpatest.repository.weather;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.song.springjpatest.entity.QRegion;
import com.song.springjpatest.entity.QWeather;
import com.song.springjpatest.entity.QcFlag;
import com.song.springjpatest.entity.Weather;
import lombok.RequiredArgsConstructor;
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
