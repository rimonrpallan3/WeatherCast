package com.rimon.weathercast.activity.landing.model;

import java.util.List;

/**
 * Created by rimon on 17-04-2019.
 */

public class ForecastBean {
    private List<ForecastdayBean> forecastday;

    public List<ForecastdayBean> getForecastday() {
        return forecastday;
    }

    public void setForecastday(List<ForecastdayBean> forecastday) {
        this.forecastday = forecastday;
    }

}