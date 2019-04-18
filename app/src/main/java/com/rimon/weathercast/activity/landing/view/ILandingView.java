package com.rimon.weathercast.activity.landing.view;

import com.rimon.weathercast.activity.landing.model.CurrentWeather;

import io.reactivex.disposables.Disposable;

/**
 * Created by rimon on 17-04-2019.
 */

public interface ILandingView {
    void showError();
    void removeError();
    void unSubscribeCalls(Disposable dMainListObservable);
    void setDataList(CurrentWeather currentWeather);
}
