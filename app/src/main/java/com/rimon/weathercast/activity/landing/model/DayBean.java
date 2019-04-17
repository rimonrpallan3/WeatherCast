package com.rimon.weathercast.activity.landing.model;

/**
 * Created by rimon on 17-04-2019.
 */

public class DayBean {
    /**
     * maxtemp_c : 33.1
     * maxtemp_f : 91.6
     * mintemp_c : 27.9
     * mintemp_f : 82.2
     * avgtemp_c : 30.2
     * avgtemp_f : 86.3
     * maxwind_mph : 10.3
     * maxwind_kph : 16.6
     * totalprecip_mm : 21.8
     * totalprecip_in : 0.86
     * avgvis_km : 15.1
     * avgvis_miles : 9
     * avghumidity : 76
     * condition : {"text":"Moderate or heavy rain shower","icon":"//cdn.apixu.com/weather/64x64/day/356.png","code":1243}
     * uv : 13.4
     */

    private double maxtemp_c;
    private double maxtemp_f;
    private double mintemp_c;
    private double mintemp_f;
    private double avgtemp_c;
    private double avgtemp_f;
    private double maxwind_mph;
    private double maxwind_kph;
    private double totalprecip_mm;
    private double totalprecip_in;
    private double avgvis_km;
    private int avgvis_miles;
    private int avghumidity;
    private ConditionBean condition;
    private double uv;

    public double getMaxtemp_c() {
        return maxtemp_c;
    }

    public void setMaxtemp_c(double maxtemp_c) {
        this.maxtemp_c = maxtemp_c;
    }

    public double getMaxtemp_f() {
        return maxtemp_f;
    }

    public void setMaxtemp_f(double maxtemp_f) {
        this.maxtemp_f = maxtemp_f;
    }

    public double getMintemp_c() {
        return mintemp_c;
    }

    public void setMintemp_c(double mintemp_c) {
        this.mintemp_c = mintemp_c;
    }

    public double getMintemp_f() {
        return mintemp_f;
    }

    public void setMintemp_f(double mintemp_f) {
        this.mintemp_f = mintemp_f;
    }

    public double getAvgtemp_c() {
        return avgtemp_c;
    }

    public void setAvgtemp_c(double avgtemp_c) {
        this.avgtemp_c = avgtemp_c;
    }

    public double getAvgtemp_f() {
        return avgtemp_f;
    }

    public void setAvgtemp_f(double avgtemp_f) {
        this.avgtemp_f = avgtemp_f;
    }

    public double getMaxwind_mph() {
        return maxwind_mph;
    }

    public void setMaxwind_mph(double maxwind_mph) {
        this.maxwind_mph = maxwind_mph;
    }

    public double getMaxwind_kph() {
        return maxwind_kph;
    }

    public void setMaxwind_kph(double maxwind_kph) {
        this.maxwind_kph = maxwind_kph;
    }

    public double getTotalprecip_mm() {
        return totalprecip_mm;
    }

    public void setTotalprecip_mm(double totalprecip_mm) {
        this.totalprecip_mm = totalprecip_mm;
    }

    public double getTotalprecip_in() {
        return totalprecip_in;
    }

    public void setTotalprecip_in(double totalprecip_in) {
        this.totalprecip_in = totalprecip_in;
    }

    public double getAvgvis_km() {
        return avgvis_km;
    }

    public void setAvgvis_km(double avgvis_km) {
        this.avgvis_km = avgvis_km;
    }

    public int getAvgvis_miles() {
        return avgvis_miles;
    }

    public void setAvgvis_miles(int avgvis_miles) {
        this.avgvis_miles = avgvis_miles;
    }

    public int getAvghumidity() {
        return avghumidity;
    }

    public void setAvghumidity(int avghumidity) {
        this.avghumidity = avghumidity;
    }

    public ConditionBean getCondition() {
        return condition;
    }

    public void setCondition(ConditionBean condition) {
        this.condition = condition;
    }

    public double getUv() {
        return uv;
    }

    public void setUv(double uv) {
        this.uv = uv;
    }

}