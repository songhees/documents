package com.song.springjpatest.repository.weather;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.song.springjpatest.entity.QWeather;
import com.song.springjpatest.entity.QcFlag;
import com.song.springjpatest.entity.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class WeatherRepositoryImpl implements WeatherRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Weather> getWeathersByRegion(Long id) {
        return List.of();
    }

    @Override
    public void updateWeathersFlag(String flag) {
        QcFlag qcFlag = QcFlag.valueOf(flag);
        QWeather weather = QWeather.weather;
        jpaQueryFactory.update(weather)
                .set(weather.qcFlag, qcFlag).execute();
    }
}
