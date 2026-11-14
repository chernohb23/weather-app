package com.weather.demo.weather_app.transformer;

import com.weather.demo.weather_app.domain.CityWeather;
import com.weather.demo.weather_app.entity.OpenWeatherResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherTransformer {
    public CityWeather transformToDomain(final OpenWeatherResponseEntity openWeatherResponseEntity){
        return CityWeather.builder()
                .weather(openWeatherResponseEntity.getWeather()[0].getMain())
                .details(openWeatherResponseEntity.getWeather()[0].getDesc())
                .build();
    }
}
