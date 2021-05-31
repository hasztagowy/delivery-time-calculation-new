package com.studenci.apkameta.DeliveryWindow;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;

@Entity

public class DeliveryWindow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "from_1")
    private String from;
    @Column(name = "to_1")
    private String to;

    public DeliveryWindow() {
    }

    public DeliveryWindow(String from, String to) {
        this.from = from;
        this.to = to;
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

    public String getFromM() {
        String  minute = "";
        for (int i=0; i<from.length(); i++) {
            if (i==2 || i==3)
                minute += from.charAt(i);
        }
        return minute;
    }
    public String getFromH() {
        String hour = "";
        for (int i=0; i<from.length(); i++) {
            if (i==0 || i==1)
                hour += from.charAt(i);
        }
        return hour;
    }
    public String getToM() {
        String  minute = "";
        for (int i=0; i<to.length(); i++) {
            if (i==2 || i==3)
                minute += to.charAt(i);
        }
        return minute;
    }
    public String getToH() {
        String hour = "";
        for (int i=0; i<to.length(); i++) {
            if (i==0 || i==1)
                hour += to.charAt(i);
        }
        return hour;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
