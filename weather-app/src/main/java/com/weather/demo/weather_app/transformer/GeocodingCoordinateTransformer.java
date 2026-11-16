package com.weather.demo.weather_app.transformer;

import com.weather.demo.weather_app.domain.CityCoordinates;
import com.weather.demo.weather_app.entity.GeocodingCoordinatesEntity;
import com.weather.demo.weather_app.service.WeatherService;
import org.springframework.stereotype.Service;

@Service
public class GeocodingCoordinateTransformer {
    public CityCoordinates transformToDomain(final GeocodingCoordinatesEntity geocodingCoordinatesEntity){
        return CityCoordinates.builder()
                .latitude(geocodingCoordinatesEntity.getLatitude())
                .longitude(geocodingCoordinatesEntity.getLongitude())
                .build();
    }
}
