package com.test.littleweatherforecast.entity;

import com.test.littleweatherforecast.entity.nested.Current;
import com.test.littleweatherforecast.entity.nested.Hourly;

import java.util.ArrayList;

public class HourlyForecast {
    public double lat;
    public double lon;
    public String timezone;
    public int timezone_offset;
    public ArrayList<Hourly> hourly;
    public ArrayList<Daily> daily;

    public HourlyForecast(){

    }

    public HourlyForecast(double lat, double lon, String timezone, int timezone_offset, ArrayList<Hourly> hourly, ArrayList<Daily> daily) {
        this.lat = lat;
        this.lon = lon;
        this.timezone = timezone;
        this.timezone_offset = timezone_offset;
        this.hourly = hourly;
        this.daily = daily;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getTimezone_offset() {
        return timezone_offset;
    }

    public void setTimezone_offset(int timezone_offset) {
        this.timezone_offset = timezone_offset;
    }

    public ArrayList<Hourly> getHourly() {
        return hourly;
    }

    public void setHourly(ArrayList<Hourly> hourly) {
        this.hourly = hourly;
    }

    public ArrayList<Daily> getDaily() {
        return daily;
    }

    public void setDaily(ArrayList<Daily> daily) {
        this.daily = daily;
    }
}
