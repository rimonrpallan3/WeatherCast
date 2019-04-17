package com.rimon.weathercast.activity.landing.model;

/**
 * Created by rimon on 17-04-2019.
 */

public class AstroBean  {
    /**
     * sunrise : 06:14 AM
     * sunset : 06:35 PM
     * moonrise : 04:48 PM
     * moonset : 04:29 AM
     */

    private String sunrise;
    private String sunset;
    private String moonrise;
    private String moonset;

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }

    public String getMoonset() {
        return moonset;
    }

    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }
}