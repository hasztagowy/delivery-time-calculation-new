package com.studenci.apkameta.modules;

import com.studenci.apkameta.transit.TransitTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
