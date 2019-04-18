package com.rimon.weathercast.activity.landing.model;

import java.util.List;

/**
 * Created by rimon on 17-04-2019.
 */

public class ForecastBean {
    private List<ForecastDayBean> forecastday;

    public List<ForecastDayBean> getForecastday() {
        return forecastday;
    }

    public void setForecastday(List<ForecastDayBean> forecastday) {
        this.forecastday = forecastday;
    }

}