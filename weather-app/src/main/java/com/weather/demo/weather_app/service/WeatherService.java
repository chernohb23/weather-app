package com.weather.demo.weather_app.service;

import com.weather.demo.weather_app.domain.CityCoordinates;
import com.weather.demo.weather_app.domain.WeatherRequestDetails;
import com.weather.demo.weather_app.entity.WeatherResponse;
import com.weather.demo.weather_app.provider.GeocodingProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private GeocodingProvider geocodingProvider;

    @Autowired // if this is the only constructor we make then @Autowired isn't required
    public WeatherService(final GeocodingProvider geocodingProvider){
        this.geocodingProvider = geocodingProvider;
    }

    public WeatherResponse getWeather(final WeatherRequestDetails weatherRequestDetails){
        // get lat and long
        final CityCoordinates cityCoordinates = geocodingProvider.getCoordinates(weatherRequestDetails);
    }
}
