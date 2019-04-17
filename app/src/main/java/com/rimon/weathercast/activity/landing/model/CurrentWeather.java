package com.rimon.weathercast.activity.landing.model;

/**
 * Created by rimon on 17-04-2019.
 */

public class CurrentWeather {


    /**
     * location : {"name":"Ernakulam","region":"Kerala","country":"India","lat":9.99,"lon":76.28,"tz_id":"Asia/Kolkata","localtime_epoch":1555518176,"localtime":"2019-04-17 21:52"}
     * current : {"last_updated_epoch":1555517714,"last_updated":"2019-04-17 21:45","temp_c":26,"temp_f":78.8,"is_day":0,"condition":{"text":"Mist","icon":"//cdn.apixu.com/weather/64x64/night/143.png","code":1030},"wind_mph":0,"wind_kph":0,"wind_degree":0,"wind_dir":"N","pressure_mb":1011,"pressure_in":30.3,"precip_mm":0.8,"precip_in":0.03,"humidity":89,"cloud":50,"feelslike_c":29.4,"feelslike_f":84.9,"vis_km":4,"vis_miles":2,"uv":0,"gust_mph":13,"gust_kph":20.9}
     */

    private LocationBean location;
    private CurrentBean current;
    private ForecastBean forecast;

    public LocationBean getLocation() {
        return location;
    }

    public void setLocation(LocationBean location) {
        this.location = location;
    }

    public CurrentBean getCurrent() {
        return current;
    }

    public void setCurrent(CurrentBean current) {
        this.current = current;
    }

    public ForecastBean getForecast() {
        return forecast;
    }

    public void setForecast(ForecastBean forecast) {
        this.forecast = forecast;
    }


}
