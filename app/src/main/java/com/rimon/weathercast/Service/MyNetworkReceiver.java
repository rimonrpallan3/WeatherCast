package com.rimon.weathercast.Service;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.rimon.weathercast.AppController;

/**
 * Created by User on 26-Apr-19.
 */

public class MyNetworkReceiver extends BroadcastReceiver {
    private final String TAG = "MyNetworkReciver";
    public static boolean isActive=false;


    @Override
    public void onReceive(Context context, Intent intent) {
        isActive = isOnline(context);
        Activity activity = AppController.mActivity ; // Getting Current Activity
        if (!isActive) {
            //if internet connection disconnected, then this block exceutes
            //activity is currently running activity
        }
    }
    //returns internet connection
    public boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            //should check null because in airplane mode it will be null
            return (netInfo != null && netInfo.isConnected());

        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }
}