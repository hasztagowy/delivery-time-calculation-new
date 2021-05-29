package com.studenci.apkameta.transit;

import com.google.gson.GsonBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransitTimeAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public int Duration;

    public TransitTimeAvailability() {
    }

    public TransitTimeAvailability(int duration, boolean isMonday, boolean isTuesday, boolean isWednesday, boolean isThursday, boolean isFriday, boolean isSaturday, boolean isSunday) {
        Duration = duration;
        IsMonday = isMonday;
        IsTuesday = isTuesday;
        IsWednesday = isWednesday;
        IsThursday = isThursday;
        IsFriday = isFriday;
        IsSaturday = isSaturday;
        IsSunday = isSunday;
    }

    public boolean IsMonday;

    public boolean IsTuesday;

    public boolean IsWednesday;

    public boolean IsThursday;

    public boolean IsFriday;

    public boolean IsSaturday;

    public boolean IsSunday;

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public boolean isMonday() {
        return IsMonday;
    }

    public void setMonday(boolean monday) {
        IsMonday = monday;
    }

    public boolean isTuesday() {
        return IsTuesday;
    }

    public void setTuesday(boolean tuesday) {
        IsTuesday = tuesday;
    }

    public boolean isWednesday() {
        return IsWednesday;
    }

    public void setWednesday(boolean wednesday) {
        IsWednesday = wednesday;
    }

    public boolean isThursday() {
        return IsThursday;
    }

    public void setThursday(boolean thursday) {
        IsThursday = thursday;
    }

    public boolean isFriday() {
        return IsFriday;
    }

    public void setFriday(boolean friday) {
        IsFriday = friday;
    }

    public boolean isSaturday() {
        return IsSaturday;
    }

    public void setSaturday(boolean saturday) {
        IsSaturday = saturday;
    }

    public boolean isSunday() {
        return IsSunday;
    }

    public void setSunday(boolean sunday) {
        IsSunday = sunday;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}

