package com.studenci.apkameta.transit;

import com.google.gson.GsonBuilder;

import java.util.List;

public class PredictableDates {
    String purchaseDate;
    List<PredictableDate> predictableDates;

    public PredictableDates(String purchaseDate, List<PredictableDate> predictableDates) {
        this.purchaseDate = purchaseDate;
        this.predictableDates = predictableDates;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public List<PredictableDate> getPredictableDates() {
        return predictableDates;
    }

    public void setPredictableDates(List<PredictableDate> predictableDates) {
        this.predictableDates = predictableDates;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
