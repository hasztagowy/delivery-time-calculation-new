package com.studenci.apkameta.modules;

import com.google.gson.GsonBuilder;
import com.studenci.apkameta.DeliveryWindow.DeliveryWindow;
import com.studenci.apkameta.Service.Service;

import java.util.Arrays;

public class Module {
    private String code;
    private Service[] services;
    private DeliveryWindow deliveryWindow;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Service[] getServices() {
        return services;
    }

    public void setServices(Service[] services) {
        this.services = services;
    }

    public DeliveryWindow getDeliveryWindow() {
        return deliveryWindow;
    }

    public void setDeliveryWindow(DeliveryWindow deliveryWindow) {
        this.deliveryWindow = deliveryWindow;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
