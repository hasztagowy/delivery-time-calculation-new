package com.studenci.apkameta.Service;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.gson.GsonBuilder;
import com.studenci.apkameta.modules.Module;
import com.studenci.apkameta.transit.TransitTime;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(cascade = {CascadeType.ALL})
    private List<TransitTime> transitTimes = new ArrayList<>();

    private String name;

    public Service() {
    }

    public Service( List<TransitTime> transitTimes, String name) {

        this.transitTimes = transitTimes;
        this.name = name;
    }



    public List<TransitTime> getTransitTimes() {
        return transitTimes;
    }

    public void setTransitTimes(List<TransitTime> transitTimes) {
        this.transitTimes = transitTimes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
