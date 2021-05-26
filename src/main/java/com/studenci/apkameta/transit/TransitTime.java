package com.studenci.apkameta.transit;

import com.google.gson.GsonBuilder;

public class TransitTime {

    private String from;
    private String to;

    private TransitTimeAvailability Dispatch;
    private TransitTimeAvailability Transit;
    private TransitTimeAvailability Delivery;


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public TransitTimeAvailability getDispatch() {
        return Dispatch;
    }

    public void setDispatch(TransitTimeAvailability dispatch) {
        Dispatch = dispatch;
    }

    public TransitTimeAvailability getTransit() {
        return Transit;
    }

    public void setTransit(TransitTimeAvailability transit) {
        Transit = transit;
    }

    public TransitTimeAvailability getDelivery() {
        return Delivery;
    }

    public void setDelivery(TransitTimeAvailability delivery) {
        Delivery = delivery;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
