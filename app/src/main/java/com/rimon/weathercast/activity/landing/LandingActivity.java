package com.rimon.weathercast.activity.landing;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.rimon.weathercast.BuildConfig;
import com.rimon.weathercast.R;
import com.rimon.weathercast.activity.landing.adapter.ForecastListAdapter;
import com.rimon.weathercast.activity.landing.model.CurrentWeather;
import com.rimon.weathercast.activity.landing.presenter.ILandingPresenter;
import com.rimon.weathercast.activity.landing.presenter.LandingPresenter;
import com.rimon.weathercast.activity.landing.view.ILandingView;
import com.rimon.weathercast.appconfig.AppConfig;
import com.rimon.weathercast.common.Helper;
import com.rimon.weathercast.common.NetworkDetector;
import com.rimon.weathercast.common.PermissionUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by rimon on 17-04-2019.
 */

public class LandingActivity extends AppCompatActivity implements ILandingView{

    RecyclerView rvForecastList;
    TextView tvPlace;
    TextView tvCTemp;
    LinearLayout error;
    LinearLayout llMainPage;
    ILandingPresenter iLandingPresenter;
    Location location;
    String apikey = "";
    String apiForecastCount = "";
    Disposable dMainListObservable;
    Button btnRetry;
    ForecastListAdapter forecastListAdapter;
    double latitude =9.994340;
    double longitude= 76.276756;
    public static final int RC_LOC_PERM = 321;
    /*https://github.com/jaisonfdo/LocationHelper*/
    private FusedLocationProviderClient mFusedLocationClient;
    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;


    protected Location mLastLocation;

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
        iLandingPresenter = new LandingPresenter(this, this, apikey, apiForecastCount);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        AppConfig.BASE_URL=getResources().getString(R.string.BASE_URL);

        //getLastLocation();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!checkPermissions()) {
            requestPermissions();
        } else {
            getLastLocation();
        }
    }




    @SuppressWarnings("MissingPermission")
    private void getLastLocation() {
        iLandingPresenter.getWeatherForecastWebService(String.valueOf(latitude), String.valueOf(longitude));
       /* mFusedLocationClient.getLastLocation()
                .addOnCompleteListener(this, new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        if (task.isSuccessful() && task.getResult() != null) {
                            mLastLocation = task.getResult();
                            iLandingPresenter.getWeatherForecastWebService(String.valueOf(mLastLocation.getLatitude()), String.valueOf(mLastLocation.getLongitude()));
                        } else {
                            Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.snack_error_location_null), Snackbar.LENGTH_LONG).show();
                            showError();
                        }
                    }
                });*/
    }

   /* @SuppressLint("MissingPermission")
    @AfterPermissionGranted(RC_LOC_PERM)
    public void getLocDetails(){
        if(NetworkDetector.haveNetworkConnection(this)) {
            //iLandingPresenter.getWeatherForecastWebService(String.valueOf(latitude), String.valueOf(longitude));

            String[] perms = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
            if (EasyPermissions.hasPermissions(this, perms)) {
                mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                //mLocationManager.requestLocationUpdates(provider, 0, 0, (LocationListener) this);
                fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
                location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (location != null) {
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();

                    // Logic to handle location object
                } else {
                    LocationListener locationListener = new LocationListener() {
                        public void onLocationChanged(Location location) {
                            // Called when a new location is found by the network location provider.
                            if (location != null) {
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();
                                iLandingPresenter.getWeatherForecastWebService(String.valueOf(latitude), String.valueOf(longitude));
                            }else {
                                showError();
                                Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.snack_error_location_null), Snackbar.LENGTH_LONG).show();
                            }
                        }

                        public void onStatusChanged(String provider, int status, Bundle extras) {}

                        public void onProviderEnabled(String provider) {}

                        public void onProviderDisabled(String provider) {}
                    };

                // Register the listener with the Location Manager to receive location updates
                    mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);

                }
               *//* fusedLocationClient.getLastLocation()
                        .addOnSuccessListener(this, new OnSuccessListener<Location>() {

                            @Override
                            public void onSuccess(Location location) {
                                // Got last known location. In some rare situations this can be null.
                                if (location != null) {
                                    latitude = location.getLatitude();
                                    longitude = location.getLongitude();
                                    iLandingPresenter.getWeatherForecastWebService(String.valueOf(latitude), String.valueOf(longitude));
                                    // Logic to handle location object
                                } else {
                                    showError();
                                    Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.snack_error_location_null), Snackbar.LENGTH_LONG).show();

                                }
                            }
                        });*//*

            } else {
                // Ask for one permission
                showError();
                EasyPermissions.requestPermissions(this, getString(R.string.loc_perm),
                        RC_LOC_PERM, perms);
            }
        } else {
            Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.snack_error_network), Snackbar.LENGTH_LONG).show();
        }

        *//*if(location!=null) {
            removeError();
            iLandingPresenter.getWeatherForecastWebService(String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()));
        }else {
            showError();
            Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.snack_error_location_null), Snackbar.LENGTH_LONG).show();
        }*//*
    }
*/




    public void onRetry(View view){
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        getLastLocation();
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
            int Temp = (int) currentWeather.getCurrent().getTemp_c();
            tvCTemp.setText(Temp+"");
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



    /**
     * Return the current state of the permissions needed.
     */
    private boolean checkPermissions() {
        int permissionState = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION);
        return permissionState == PackageManager.PERMISSION_GRANTED;
    }

    private void startLocationPermissionRequest() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                REQUEST_PERMISSIONS_REQUEST_CODE);
    }

    private void requestPermissions() {
        boolean shouldProvideRationale =
                ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION);

        // Provide an additional rationale to the user. This would happen if the user denied the
        // request previously, but didn't check the "Don't ask again" checkbox.
        if (shouldProvideRationale) {

            Snackbar.make(findViewById(android.R.id.content),
                    getResources().getString(R.string.permission_rationale),
                    Snackbar.LENGTH_INDEFINITE)
                    .setAction(getResources().getString(android.R.string.ok), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startLocationPermissionRequest();
                        }
                    }).show();

        } else {
            // Request permission. It's possible this can be auto answered if device policy
            // sets the permission in a given state or the user denied the permission
            // previously and checked "Never ask again".
            startLocationPermissionRequest();
        }
    }

    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
            if (grantResults.length <= 0) {
                // If user interaction was interrupted, the permission request is cancelled and you
                // receive empty arrays.
            } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted.
                getLastLocation();
            } else {
                // Permission denied.

                // Notify the user via a SnackBar that they have rejected a core permission for the
                // app, which makes the Activity useless. In a real app, core permissions would
                // typically be best requested during a welcome-screen flow.

                // Additionally, it is important to remember that a permission might have been
                // rejected without asking the user for permission (device policy or "Never ask
                // again" prompts). Therefore, a user interface affordance is typically implemented
                // when permissions are denied. Otherwise, your app could appear unresponsive to
                // touches or interactions which have required permissions.

                Snackbar.make(findViewById(android.R.id.content),
                        getResources().getString(R.string.permission_denied_explanation),
                        Snackbar.LENGTH_INDEFINITE)
                        .setAction(getResources().getString( R.string.settings), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent();
                                intent.setAction(
                                        Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                Uri uri = Uri.fromParts("package",
                                        BuildConfig.APPLICATION_ID, null);
                                intent.setData(uri);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        }).show();
            }
        }
    }

}
