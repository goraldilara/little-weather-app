package dg.littleweather.domain.entity;

import java.util.List;

public interface WeatherDTO {
    List<CityWeather> getWeatherForCities();
    CityWeather getWeatherByCity();
    List<CityWeather> saveWeathers();
    List<CityWeather> saveWeatherByCity();
}
