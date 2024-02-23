package com.test.littleweatherforecast.service;

import com.test.littleweatherforecast.entity.CityWeather;

import java.util.List;

public interface WeatherService {

    List<CityWeather> getWeatherforCities();
    CityWeather getWeatherByCity();
    List<CityWeather> saveWeathers();
    CityWeather saveWeatherByCity(String cityName);
}
