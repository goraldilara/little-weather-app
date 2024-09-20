package dg.littleweather.domain.entity;

public class HourlyData {
    private String dateAndHour;
    private double max_temp;
    private double feels_like_temp;
    private int humidity_rate;

    public HourlyData(){

    }

    public HourlyData(String dateAndHour, double max_temp, double feels_like_temp, int humidity_rate) {
        this.dateAndHour = dateAndHour;
        this.max_temp = max_temp;
        this.feels_like_temp = feels_like_temp;
        this.humidity_rate = humidity_rate;
    }

    public String getDateAndHour() {
        return dateAndHour;
    }

    public void setDateAndHour(String dateAndHour) {
        this.dateAndHour = dateAndHour;
    }

    public double getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(double max_temp) {
        this.max_temp = max_temp;
    }

    public double getFeels_like_temp() {
        return feels_like_temp;
    }

    public void setFeels_like_temp(double feels_like_temp) {
        this.feels_like_temp = feels_like_temp;
    }

    public int getHumidity_rate() {
        return humidity_rate;
    }

    public void setHumidity_rate(int humidity_rate) {
        this.humidity_rate = humidity_rate;
    }
}
