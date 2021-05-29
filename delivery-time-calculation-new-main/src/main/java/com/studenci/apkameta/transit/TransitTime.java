package com.studenci.apkameta.transit;

import com.google.gson.GsonBuilder;
import com.studenci.apkameta.Service.Service;
import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;

@Entity
public class TransitTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "from_1")
    private String from;
    @Column(name = "to_1")
    private String to;


    @OneToOne(cascade = {CascadeType.ALL})
    private TransitTimeAvailability Dispatch;
    @OneToOne(cascade = {CascadeType.ALL})
    private TransitTimeAvailability Transit;
    @OneToOne(cascade = {CascadeType.ALL})
    private TransitTimeAvailability Delivery;


    public TransitTime() {
    }

    public TransitTime(String from, String to, TransitTimeAvailability dispatch, TransitTimeAvailability transit, TransitTimeAvailability delivery) {
        this.from = from;
        this.to = to;
        Dispatch = dispatch;
        Transit = transit;
        Delivery = delivery;
    }


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
