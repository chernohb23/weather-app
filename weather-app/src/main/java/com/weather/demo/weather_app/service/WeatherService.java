package com.weather.demo.weather_app.service;

import com.weather.demo.weather_app.domain.CityCoordinates;
import com.weather.demo.weather_app.domain.CityWeather;
import com.weather.demo.weather_app.domain.WeatherRequestDetails;
import com.weather.demo.weather_app.entity.WeatherResponse;
import com.weather.demo.weather_app.provider.GeocodingProvider;
import com.weather.demo.weather_app.provider.WeatherProvider;
import com.weather.demo.weather_app.transformer.GeocodingCoordinateTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final GeocodingProvider geocodingProvider;
    private final GeocodingCoordinateTransformer geocodingCoordinateTransformer;
    private final WeatherProvider weatherProvider;

    @Autowired // if this is the only constructor we make then @Autowired isn't required
    public WeatherService(final GeocodingProvider geocodingProvider, final GeocodingCoordinateTransformer geocodingCoordinateTransformer, final WeatherProvider weatherProvider){
        this.geocodingProvider = geocodingProvider;
        this.geocodingCoordinateTransformer = geocodingCoordinateTransformer;
        this.weatherProvider = weatherProvider;
    }

    public WeatherResponse getWeather(final WeatherRequestDetails weatherRequestDetails) throws Exception {

        // get lat and long
        final CityCoordinates cityCoordinates = geocodingCoordinateTransformer
                .transformToDomain(geocodingProvider.getCoordinates(weatherRequestDetails));

        // get weather
        final CityWeather cityWeather = weatherProvider.getWeather(cityCoordinates);
    }

}
