package com.rimon.weathercast.activity.landing.model;

/**
 * Created by rimon on 17-04-2019.
 */

public class ForecastDayBean {
    /**
     * date : 2019-04-17
     * date_epoch : 1555459200
     * day : {"maxtemp_c":33.1,"maxtemp_f":91.6,"mintemp_c":27.9,"mintemp_f":82.2,"avgtemp_c":30.2,"avgtemp_f":86.3,"maxwind_mph":10.3,"maxwind_kph":16.6,"totalprecip_mm":21.8,"totalprecip_in":0.86,"avgvis_km":15.1,"avgvis_miles":9,"avghumidity":76,"condition":{"text":"Moderate or heavy rain shower","icon":"//cdn.apixu.com/weather/64x64/day/356.png","code":1243},"uv":13.4}
     * astro : {"sunrise":"06:14 AM","sunset":"06:35 PM","moonrise":"04:48 PM","moonset":"04:29 AM"}
     */

    private String date;
    private int date_epoch;
    private DayBean day;
    private AstroBean astro;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDate_epoch() {
        return date_epoch;
    }

    public void setDate_epoch(int date_epoch) {
        this.date_epoch = date_epoch;
    }

    public DayBean getDay() {
        return day;
    }

    public void setDay(DayBean day) {
        this.day = day;
    }

    public AstroBean getAstro() {
        return astro;
    }

    public void setAstro(AstroBean astro) {
        this.astro = astro;
    }


}