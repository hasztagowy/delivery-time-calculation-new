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

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
