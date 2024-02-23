package com.test.littleweatherforecast.entity.nested;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {
    @JsonProperty("1h")
    public double _1h;
    @JsonProperty("3h")
    public double _3h;

    public Rain(){

    }

    public Rain(double _1h) {
        this._1h = _1h;
    }

    public Rain(double _1h, double _3h) {
        this._1h = _1h;
        this._3h = _3h;
    }

    public double get_1h() {
        return _1h;
    }

    public void set_1h(double _1h) {
        this._1h = _1h;
    }

    public double get_3h() {
        return _3h;
    }

    public void set_3h(double _3h) {
        this._3h = _3h;
    }
}
