package com.studenci.apkameta.modules;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.gson.GsonBuilder;
import com.studenci.apkameta.DeliveryWindow.DeliveryWindow;
import com.studenci.apkameta.Service.Service;
import com.studenci.apkameta.transit.TransitTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Service> services = new ArrayList<>();

    @OneToOne(cascade = {CascadeType.ALL})
    private DeliveryWindow deliveryWindow;

    public Module() {
    }

    public Module(String code, DeliveryWindow deliveryWindow, List<Service> services) {
        this.code = code;
        this.deliveryWindow = deliveryWindow;
        this.services = services;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DeliveryWindow getDeliveryWindow() {
        return deliveryWindow;
    }

    public void setDeliveryWindow(DeliveryWindow deliveryWindow) {
        this.deliveryWindow = deliveryWindow;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}

