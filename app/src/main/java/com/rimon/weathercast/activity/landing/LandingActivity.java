package com.rimon.weathercast.activity.landing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.rimon.weathercast.R;

/**
 * Created by rimon on 17-04-2019.
 */

public class LandingActivity extends AppCompatActivity {

    RecyclerView rvForecastList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        rvForecastList = findViewById(R.id.rvForecastList);

    }
}
