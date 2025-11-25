package com.batch.spirng_batch.repository.weather;

import com.batch.spirng_batch.entity.Weather;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WeatherRepository {

    List<Weather> getWeatherAll();

    List<Weather> getWeatherAllFetch();

    Page<Weather> findAllPaging(Pageable pageable);

    List<Weather> getWeathersByRegion(Long id);

    List<Weather> getWeathersByRegionFetch(Long id);

    void updateWeathersFlag(String flag);
}
