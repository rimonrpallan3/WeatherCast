package com.rimon.weathercast.activity.landing.presenter;

import com.rimon.weathercast.activity.landing.view.ILandingView;

/**
 * Created by rimon on 17-04-2019.
 */

public interface ILandingPresenter {
    void onViewAttached(ILandingView iLandingView, boolean isNew);
    void onViewDetached();
    public void getWeatherForecastWebService(String lat, String lng, String apiKey,String apiForecastCount);

}
