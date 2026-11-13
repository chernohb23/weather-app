package com.weather.demo.weather_app.resource;

import com.weather.demo.weather_app.domain.WeatherRequestDetails;
import com.weather.demo.weather_app.entity.WeatherResponse;
import com.weather.demo.weather_app.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class WeatherResource {

    private final WeatherService weatherService;

    @Autowired // if this is the only constructor we make then @Autowired isn't required
    public WeatherResource(final WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @GetMapping("/weather/{city}")
    public WeatherResponse weather(@PathVariable("city") String city) throws Exception { // don't need to specify "ResponseBody" cuz this is a @RestController
        final WeatherRequestDetails weatherRequestDetails = WeatherRequestDetails.builder()
                .city(city)
                .build();
        return weatherService.getWeather(weatherRequestDetails);
    }
}
