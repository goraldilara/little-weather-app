package com.test.littleweatherforecast.entity.nested;

public class Wind {
    public double speed;
    public int deg;
    public double gust;

    public Wind(){

    }

    public Wind(double speed, int deg, double gust) {
        this.speed = speed;
        this.deg = deg;
        this.gust = gust;
    }

    public Wind(double speed, int deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

//    public double getGust() {
//        return gust;
//    }
//
//    public void setGust(double gust) {
//        this.gust = gust;
//    }
}
