package com.test.littleweatherforecast.service;

import com.test.littleweatherforecast.entity.CityInfoDTO;
import com.test.littleweatherforecast.entity.CityWeather;
import com.test.littleweatherforecast.entity.HourlyForecast;
import com.test.littleweatherforecast.entity.nested.HourlyData;
import com.test.littleweatherforecast.rest.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class WeatherServiceImpl implements WeatherService{

    //constant values for api addresses and api key
    final String OPEN_WEATHER_API_URL = "https://api.openweathermap.org/data/2.5/weather";
    final String WEATHER_INFO_API_URL = "https://api.openweathermap.org/data/2.5/onecall";
    final String OPEN_WEATHER_API_KEY = "47f06c26dcd2450582b41991bc72b209";
    //lists and fields that are needed in the requests
    static List<CityWeather> weathers = new ArrayList<CityWeather>();
    static ArrayList<HourlyData> hourlyData = new ArrayList<HourlyData>();
    static HashMap<String,Double> max_temp_of_the_day = new HashMap<String, Double>();
    private String dateAndHour = "";
    private double max_temp = 0.0;
    private double feels_like_temp = 0.0;
    private int humidity_rate = 0;

    @Override
    public List<CityWeather> getWeatherforCities() {
        return null;
    }

    @Override
    public CityWeather getWeatherByCity() {
        return null;
    }

    @Override
    public List<CityWeather> saveWeathers() {
        return null;
    }

    @Override
    public CityWeather saveWeatherByCity(String cityName) {
        //get current weather information of the given city
        String infoUrl = OPEN_WEATHER_API_URL + "?q=" + cityName + "&appid=" + OPEN_WEATHER_API_KEY;

        //usage of the rest template to get api connections
        RestTemplate restTemplate = new RestTemplate();
        //get object data from api with given url
        CityInfoDTO cityInfo = restTemplate.getForObject(infoUrl, CityInfoDTO.class);
        //throw an exception if data not found
        if(cityInfo == null){
            throw new DataNotFoundException("The weather information for the city called " + cityName + " not found");
        }
        //set exclude parameter of the url
        String exclude = "current,minutely,alerts";

        //call url to get data through the related object
        String hourlyInfo = WEATHER_INFO_API_URL + "?lat=" + cityInfo.coord.getLat() + "&lon=" + cityInfo.coord.getLon() + "&exclude=" + exclude + "&appid=" + OPEN_WEATHER_API_KEY;
        HourlyForecast hourlyForecast = restTemplate.getForObject(hourlyInfo, HourlyForecast.class);
        //throw an exception if data not found
        if(hourlyForecast == null){
            throw new DataNotFoundException("The weather information for the city called " + cityName + " not found");
        }

        //fill the map with the maximum temp by daily maximum temp data
        for(int i = 0; i < 3;i++){
            max_temp_of_the_day.put(unixToDate(hourlyForecast.getDaily().get(i).dt), hourlyForecast.getDaily().get(i).getTemp().getMax());
        }

        //create HourlyData objects and fill the arraylist with objects
        for(int i = 0; i < 48; i++){
            //set dataAndHour field by unix (dt) of the hourly object in wanted order
            dateAndHour = unixToDate(hourlyForecast.getHourly().get(i).getDt(), cityName, hourlyForecast.getTimezone_offset());
            //set the max temps for the hours
            if(max_temp_of_the_day.containsKey(unixToDate(hourlyForecast.getHourly().get(i).dt))){
                max_temp = max_temp_of_the_day.get(unixToDate(hourlyForecast.getHourly().get(i).dt));
            }
            //set other fields
            feels_like_temp = hourlyForecast.getHourly().get(i).getFeels_like();
            humidity_rate = hourlyForecast.getHourly().get(i).getHumidity();
            //fill the arraylist by the HourlyData object
            hourlyData.add(new HourlyData(dateAndHour,max_temp,feels_like_temp,humidity_rate));
        }

        //create last output object
        CityWeather cityWeather = new CityWeather(cityName,hourlyData);
        return cityWeather;
    }



    //method to convert unix value in the hourly and daily fields into a date with better format
    public static String unixToDate(long unix, String zone, int offset){
        //get date by unix seconds
        Date date = new Date(unix*1000L);
        //get time zone
        String timeZone = TimeZone.getTimeZone(zone).getID().toString();
        String[] dateAndTime = date.toString().split(" ");
        //find utc by timezone offset
        int timezoneOffset = offset;
        timezoneOffset /= 3600;
        String java_offset = offsetToUtc(timezoneOffset);

        // set formatted date and hour
        String date_str = dateAndTime[0] + " " + dateAndTime[1] + " " + dateAndTime[2] + " " + dateAndTime[5] + " " + dateAndTime[3] + " " + timeZone + java_offset;
        return date_str;
    }

    //method to convert unix to date
    public static String unixToDate(long unix){
        Date date = new Date(unix*1000L);
        String[] dateAndTime = date.toString().split(" ");
        String date_str = dateAndTime[1] + " " + dateAndTime[2] + " " + dateAndTime[5];
        return date_str;
    }

    private static String offsetToUtc(int offset){
        String java_offset = "";
        //check -0X:00 condition
        if(offset < 0 && offset > -10){
            java_offset = "-0".concat(String.valueOf(Math.abs(offset)) + ":00");
        }
        //check -XX:00 condition
        else if (offset < 0 && offset <= -10) {
            java_offset = "-".concat(String.valueOf(Math.abs(offset)) + ":00");
        }
        //check +0X:00 condition
        else if(offset >= 0 && offset < 10){
            java_offset = "+0"+offset+":00";
        }
        //check +XX:00 condition
        else if(offset >= 0 && offset >= 10){
            java_offset = "+" +offset+":00";
        }
        return java_offset;
    }
}
