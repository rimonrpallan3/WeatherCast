package com.rimon.weathercast.activity.landing.presenter;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.rimon.weathercast.R;
import com.rimon.weathercast.activity.landing.model.CurrentWeather;
import com.rimon.weathercast.activity.landing.view.ILandingView;
import com.rimon.weathercast.common.NetworkDetector;
import com.rimon.weathercast.webservices.ApiClient;
import com.rimon.weathercast.webservices.WebServices;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by rimon on 17-04-2019.
 */

public class LandingPresenter implements ILandingPresenter{

    ILandingView iLandingView;
    Activity activity;
    String apiKey;
    String apiForecastCount;

    public LandingPresenter(ILandingView iLandingView) {
        this.iLandingView = iLandingView;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiForecastCount() {
        return apiForecastCount;
    }

    public void setApiForecastCount(String apiForecastCount) {
        this.apiForecastCount = apiForecastCount;
    }

    public void getWeatherForecastWebService(String lat, String lng, String apiKey, String apiForecastCount){
        if ( Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission( activity, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission( activity, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if(NetworkDetector.haveNetworkConnection(activity)){
                getData(lat,lng,apiKey,apiForecastCount);
            }else {
                //Snackbar.make(activity.findViewById(android.R.id.content), activity.getResources().getString(R.string.snack_error_network), Snackbar.LENGTH_LONG).show();
                iLandingView.showError("");
            }
        }else {
            getData(lat,lng,apiKey,apiForecastCount);
        }

    }
    public void getData(String lat, String lng, String apiKey,String apiForecastCount){
        Retrofit retrofit = new ApiClient().getRetrofitClient();
        final WebServices webServices = retrofit.create(WebServices.class);
        Observable<CurrentWeather> likedObservable = webServices.getForecastList(apiKey,lat+","+lng,apiForecastCount);
        likedObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(fetchForecastList());
    }

    private Observer<CurrentWeather> fetchForecastList() {
        return new Observer<CurrentWeather>() {

            @Override
            public void onSubscribe(Disposable d) {
                iLandingView.unSubscribeCalls(d);
                Log.d("fetchForecastList", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(CurrentWeather value) {
                iLandingView.removeError();
                CurrentWeather currentWeather= value;
                iLandingView.setDataList(currentWeather);

                Log.d("fetchForecastList", " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("fetchForecastList", " onError : " + e.getMessage());
                iLandingView.showError(e.getMessage());
                //Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.d("LocationPresenter", " onComplete");
            }
        };
    }
}
