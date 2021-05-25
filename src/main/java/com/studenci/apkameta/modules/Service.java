package com.studenci.apkameta.modules;

import com.studenci.apkameta.transit.TransitTime;

public class Service {

    private String name;
    private TransitTime[] transitTimes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TransitTime[] getTransitTimes() {
        return transitTimes;
    }

    public void setTransitTimes(TransitTime[] transitTimes) {
        this.transitTimes = transitTimes;
    }
}
