package com.rimon.weathercast.activity.landing.presenter;

/**
 * Created by rimon on 17-04-2019.
 */

public interface ILandingPresenter {
    public void getWeatherForecastWebService(String lat, String lng, String apiKey,String apiForecastCount);

}
