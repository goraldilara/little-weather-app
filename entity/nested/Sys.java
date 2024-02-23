package com.test.littleweatherforecast.entity.nested;

public class Sys {
    public String pod;

    public Sys(){

    }

    public Sys(String pod) {
        this.pod = pod;
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }
}
