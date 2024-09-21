package dg.littleweather.controller;
import dg.littleweather.domain.dto.CityInfo;
import dg.littleweather.domain.dto.CityWeatherDTO;
import dg.littleweather.service.LittleWeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class LittleWeatherController {

    //service object
    private LittleWeatherService littleWeatherService;

    //constructor injection
    public LittleWeatherController(LittleWeatherService theWeatherService){littleWeatherService = theWeatherService;}

    @PostMapping("/cityInfo")
    public CityInfo getCityInfo(){
        return littleWeatherService.getCityInfo("Ankara"); //ankara ile bilgi getir
    }

    //get a single weather for the given city name
    @PostMapping("/hourly")
    public CityWeatherDTO getHourlyWeatherByCity(@RequestBody String cityName){
        return littleWeatherService.getHourlyWeatherByCity(cityName);
    }
}
