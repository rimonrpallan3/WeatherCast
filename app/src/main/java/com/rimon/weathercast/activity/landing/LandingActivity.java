package com.rimon.weathercast.activity.landing;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.rimon.weathercast.R;
import com.rimon.weathercast.activity.landing.adapter.ForecastListAdapter;
import com.rimon.weathercast.activity.landing.model.CurrentWeather;
import com.rimon.weathercast.activity.landing.presenter.ILandingPresenter;
import com.rimon.weathercast.activity.landing.presenter.LandingPresenter;
import com.rimon.weathercast.activity.landing.view.ILandingView;
import com.rimon.weathercast.common.Helper;
import com.rimon.weathercast.common.PermissionUtils;

import java.util.ArrayList;

import io.reactivex.disposables.Disposable;

/**
 * Created by rimon on 17-04-2019.
 */

public class LandingActivity extends AppCompatActivity implements LocationListener, ILandingView {

    RecyclerView rvForecastList;
    TextView tvPlace;
    TextView tvCTemp;
    LinearLayout error;
    LinearLayout llMainPage;
    ILandingPresenter iLandingPresenter;
    String mprovider;
    Location location;
    String apikey="";
    String apiForecastCount="";
    Disposable dMainListObservable;
    Button btnRetry;
    ForecastListAdapter forecastListAdapter;
    private FusedLocationProviderClient mFusedLocationClient;

    private final static int PLAY_SERVICES_REQUEST = 1000;
    private final static int REQUEST_CHECK_SETTINGS = 2000;

    private Location mLastLocation;

    // Google client to interact with Google API

    private GoogleApiClient mGoogleApiClient;

    double latitude;
    double longitude;

    // list of permissions

    ArrayList<String> permissions=new ArrayList<>();
    PermissionUtils permissionUtils;

    boolean isPermissionGranted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        rvForecastList = findViewById(R.id.rvForecastList);
        tvPlace = findViewById(R.id.tvPlace);
        tvCTemp = findViewById(R.id.tvCTemp);
        error = findViewById(R.id.error);
        llMainPage = findViewById(R.id.llMainPage);
        btnRetry = findViewById(R.id.btnRetry);
        apikey = getResources().getString(R.string.api_key);
        apiForecastCount = getResources().getString(R.string.api_forecast_count);
        iLandingPresenter = new LandingPresenter(this, this,apikey,apiForecastCount);
        permissionUtils=new PermissionUtils(this);

        permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);

        permissionUtils.check_permission(permissions,"Need GPS permission for getting your location",1);

        getLocation();

        if (mLastLocation != null) {
            latitude = mLastLocation.getLatitude();
            longitude = mLastLocation.getLongitude();
            iLandingPresenter.getWeatherForecastWebService(String.valueOf(latitude), String.valueOf(longitude));


        } else {
                showError();
                Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.snack_error_location_null), Snackbar.LENGTH_LONG).show();

        }

        if(Helper.isLocationEnabled(this)){
            removeError();
        }else {
            showError();
            Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.snack_error_location), Snackbar.LENGTH_LONG).show();
        }
    }

    /**
     * Method to display the location on UI
     * */

    private void getLocation() {

        if (isPermissionGranted) {

            try
            {
                mLastLocation = LocationServices.FusedLocationApi
                        .getLastLocation(mGoogleApiClient);
            }
            catch (SecurityException e)
            {
                e.printStackTrace();
            }

        }

    }

    public void onRetry(View view){

    }

    @Override
    public void onLocationChanged(Location location) {
        System.out.println("LandingActivity "+location.getLongitude());

        if(location!=null) {
            removeError();
            iLandingPresenter.getWeatherForecastWebService(String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()));
        }else {
            showError();
            Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.snack_error_location_null), Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        Log.d("Latitude","status");
    }

    @Override
    public void onProviderEnabled(String s) {
        Log.d("Latitude","enable");
    }

    @Override
    public void onProviderDisabled(String s) {
        Log.d("Latitude","disable");
    }

    @Override
    public void showError() {
        error.setVisibility(View.VISIBLE);
        llMainPage.setVisibility(View.GONE);
    }

    @Override
    public void removeError() {
        error.setVisibility(View.GONE);
        llMainPage.setVisibility(View.VISIBLE);
    }

    @Override
    public void unSubscribeCalls(Disposable dMainListObservable) {
        this.dMainListObservable = dMainListObservable;
    }

    @Override
    public void setDataList(CurrentWeather currentWeather) {
        if( currentWeather != null ){
            tvPlace.setText(currentWeather.getLocation().getName());
            tvCTemp.setText(currentWeather.getCurrent().getTemp_c());
            forecastListAdapter = new ForecastListAdapter(currentWeather.getForecast().getForecastday(), this);
            rvForecastList.setLayoutFrozen(true);
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
            rvForecastList.setLayoutManager(mLayoutManager);
            rvForecastList.setItemAnimator(new DefaultItemAnimator());
            rvForecastList.setAdapter(forecastListAdapter);
        }else {
            showError();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(dMainListObservable!=null)
            dMainListObservable.dispose();
    }
}
