package com.rimon.weathercast.activity.landing.model;

/**
 * Created by rimon on 17-04-2019.
 */

public class ConditionBean {
    /**
     * text : Mist
     * icon : //cdn.apixu.com/weather/64x64/night/143.png
     * code : 1030
     */

    private String text;
    private String icon;
    private int code;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}