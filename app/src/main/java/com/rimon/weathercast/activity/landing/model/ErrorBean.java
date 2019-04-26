package com.rimon.weathercast.activity.landing.model;

/**
 * Created by User on 26-Apr-19.
 */

public class ErrorBean {
    /**
     * code : 2006
     * message : API key is invalid.
     */

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
