package com.song.springjpatest.repository.weather;

import com.song.springjpatest.entity.Weather;

import java.util.List;

public interface WeatherRepository {

    List<Weather> getWeatherAll();

    List<Weather> getWeatherAllFetch();

    List<Weather> getWeathersByRegion(Long id);

    List<Weather> getWeathersByRegionFetch(Long id);

    void updateWeathersFlag(String flag);
}
