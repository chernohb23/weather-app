package com.weather.demo.weather_app.transformer;

import com.weather.demo.weather_app.domain.CityWeather;
import com.weather.demo.weather_app.entity.OpenWeatherResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherTransformer {
    public CityWeather transformToDomain(OpenWeatherResponseEntity openWeatherResponseEntity){
        return CityWeather.builder()
                .id(openWeatherResponseEntity.getWeather()[0].getId())
                .main(openWeatherResponseEntity.getWeather()[0].getMain())
                .desc(openWeatherResponseEntity.getWeather()[0].getDesc())
                .icon(openWeatherResponseEntity.getWeather()[0].getIcon())
                .build();
    }
}
