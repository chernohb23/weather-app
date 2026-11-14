package com.weather.demo.weather_app.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CityWeather {
    private String id;
    private String main;
    private String desc;
    private String icon;
}
