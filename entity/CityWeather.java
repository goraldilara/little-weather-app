package com.test.littleweatherforecast.entity;

import com.test.littleweatherforecast.entity.nested.HourlyData;

import java.util.ArrayList;

public class CityWeather {

    //attributes
    private String city_name;
    private ArrayList<HourlyData> hourlyData;

    public CityWeather(){

    }

    public CityWeather(String city_name, ArrayList<HourlyData> hourlyData) {
        this.city_name = city_name;
        this.hourlyData = hourlyData;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public ArrayList<HourlyData> getHourlyData() {
        return hourlyData;
    }

    public void setHourlyData(ArrayList<HourlyData> hourlyData) {
        this.hourlyData = hourlyData;
    }
}
