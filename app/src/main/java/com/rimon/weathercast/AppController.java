package com.rimon.weathercast;

import android.app.Activity;
import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.rimon.weathercast.Service.MyNetworkReceiver;
import com.rimon.weathercast.appconfig.AppConfig;

/**
 * Created by User on 26-Apr-19.
 */

public class AppController extends Application {
    // Overriding this method is totally optional!
    public static Activity mActivity;
    MyNetworkReceiver mNetworkReceiver;
    private static AppController mInstance;

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appInit();
        // Required initialization logic here!
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                //mNetworkReceiver = new MyNetworkReceiver();
            }

            @Override
            public void onActivityStarted(Activity activity) {
                mActivity = activity;
            }

            @Override
            public void onActivityResumed(Activity activity) {
                mActivity = activity;
                //mNetworkReceiver = new MyNetworkReceiver();
               // registerNetworkBroadcastForNougat();
            }

            @Override
            public void onActivityPaused(Activity activity) {
                mActivity = null;
                //unregisterReceiver(mNetworkReceiver);
                Log.d("MyApplicationTest", "onActivityResumed: un-registered");
            }

            @Override
            public void onActivityStopped(Activity activity) {
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
               // unregisterReceiver(mNetworkReceiver);
            }
        });
    }

    private void parseAppConfig(){
        //others
        AppConfig.BASE_URL=getResources().getString(R.string.BASE_URL);
        AppConfig.API_KEY=getResources().getString(R.string.api_key);
        AppConfig.API_FORECAST_COUNT=getResources().getString(R.string.api_forecast_count);
    }

    private void appInit(){
        mInstance=this;
        parseAppConfig();
    }

    private void registerNetworkBroadcastForNougat() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            registerReceiver(mNetworkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }
}