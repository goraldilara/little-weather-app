package dg.littleweather.service;

import dg.littleweather.domain.entity.CityWeather;

import java.util.List;

public interface WeatherService {

    List<CityWeather> getWeatherforCities();
    CityWeather getWeatherByCity();
    List<CityWeather> saveWeathers();
    CityWeather saveWeatherByCity(String cityName);
}
