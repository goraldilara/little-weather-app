package dg.littleweather.service;

import dg.littleweather.domain.dto.CityInfo;
import dg.littleweather.domain.dto.CityWeatherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LittleWeatherService {

    OpenWeatherService openWeatherService;

    @Autowired
    public LittleWeatherService(OpenWeatherService openWeatherService) {
        this.openWeatherService = new OpenWeatherService();
    }

    public CityInfo getCityInfo(String cityName) {

        return openWeatherService.getCityInfo(cityName);
    }

    public CityWeatherDTO getHourlyWeatherByCity(String cityName) {

        CityInfo cityInfo = openWeatherService.getCityInfo(cityName);

        return openWeatherService.getHourlyWeatherByCity(cityInfo, cityName);
    }

}
