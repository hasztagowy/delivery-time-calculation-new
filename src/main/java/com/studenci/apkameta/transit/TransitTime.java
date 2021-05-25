package com.studenci.apkameta.transit;

public class TransitTime {

    private String fromCountry;
    private String toCountry;

    private TransitTimeAvailability Dispatch;
    private TransitTimeAvailability Transit;
    private TransitTimeAvailability Delivery;


    public String getFromCountry() {
        return fromCountry;
    }

    public void setFromCountry(String fromCountry) {
        this.fromCountry = fromCountry;
    }

    public String getToCountry() {
        return toCountry;
    }

    public void setToCountry(String toCountry) {
        this.toCountry = toCountry;
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
}
