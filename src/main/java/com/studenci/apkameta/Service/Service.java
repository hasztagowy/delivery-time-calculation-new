package com.studenci.apkameta.Service;

import com.google.gson.GsonBuilder;
import com.studenci.apkameta.transit.TransitTime;

import java.util.Arrays;

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

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
