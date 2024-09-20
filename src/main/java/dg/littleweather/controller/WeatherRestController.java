package dg.littleweather.controller;
import dg.littleweather.domain.entity.CityWeather;
import dg.littleweather.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherRestController {

    //service object
    private WeatherService weatherService;
    //constructor injection
    public WeatherRestController(WeatherService theWeatherService){weatherService = theWeatherService;}

    //get a single weather for the given city name
    @PostMapping("/hourly")
    public CityWeather saveWeatherByCity(@RequestBody String cityName){
        return weatherService.saveWeatherByCity(cityName);
    }
}
