package dg.littleweather.domain.nested;

import dg.littleweather.domain.dto.detailed.Rain;
import dg.littleweather.domain.dto.detailed.Snow;
import dg.littleweather.domain.dto.detailed.Weather;

import java.util.ArrayList;

public class Current {
    public int dt;
    public int sunrise;
    public int sunset;
    public double temp;
    public double feels_like;
    public int pressure;
    public int humidity;
    public double dew_point;
    public double uvi;
    public int clouds;
    public int visibility;
    public double wind_speed;
    public int wind_deg;
    public double gust;
    public Rain rain;
    public Snow snow;
    public ArrayList<Weather> weather;
}
