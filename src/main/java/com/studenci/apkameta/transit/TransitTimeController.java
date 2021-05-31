package com.studenci.apkameta.transit;

import com.studenci.apkameta.Service.Service;
import com.studenci.apkameta.Service.ServiceServiceImpl;
import com.studenci.apkameta.modules.Module;
import com.studenci.apkameta.modules.ModuleEntityRepository;
import com.studenci.apkameta.modules.ModuleEntityRepositoryImpl;
import com.studenci.apkameta.users.UserControler;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping
public class TransitTimeController {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    ModuleEntityRepositoryImpl moduleEntityRepositoryImpl;
    ServiceServiceImpl serviceServiceImpl;
    public TransitTimeController(ModuleEntityRepositoryImpl moduleEntityRepositoryImpl, ServiceServiceImpl serviceServiceImpl){
        this.moduleEntityRepositoryImpl = moduleEntityRepositoryImpl;
        this.serviceServiceImpl = serviceServiceImpl;
    }
//    ?serviceName&purchaseDate&fromCountry&toCountry
//    @RequestParam String pucharseDate, @RequestParam String fromCountry, @RequestParam String toCountry


    @GetMapping("/{moduleCode}/transitTimes")
    public List<Date> getCode(@PathVariable("moduleCode") String moduleCode, @RequestParam String serviceName,
                              @RequestParam String pucharseDate, ){

        Module module = moduleEntityRepositoryImpl.getModuleByCode(moduleCode);
        Service service = serviceServiceImpl.getServiceByName(serviceName);
        Date date = stringToDate(pucharseDate);

        boolean[] availabilityDispatch = {service.getTransitTimes().get(0).getDispatch().isSunday(),
                service.getTransitTimes().get(0).getDispatch().isMonday(),
                service.getTransitTimes().get(0).getDispatch().isTuesday(),
                service.getTransitTimes().get(0).getDispatch().isWednesday(),
                service.getTransitTimes().get(0).getDispatch().isThursday(),
                service.getTransitTimes().get(0).getDispatch().isFriday(),
                service.getTransitTimes().get(0).getDispatch().isSaturday()};

        boolean[] availabilityTransit = {service.getTransitTimes().get(0).getTransit().isSunday(),
                service.getTransitTimes().get(0).getTransit().isMonday(),
                service.getTransitTimes().get(0).getTransit().isTuesday(),
                service.getTransitTimes().get(0).getTransit().isWednesday(),
                service.getTransitTimes().get(0).getTransit().isThursday(),
                service.getTransitTimes().get(0).getTransit().isFriday(),
                service.getTransitTimes().get(0).getTransit().isSaturday()};

        boolean[] availabilityDelivery = {service.getTransitTimes().get(0).getDelivery().isSunday(),
                service.getTransitTimes().get(0).getDelivery().isMonday(),
                service.getTransitTimes().get(0).getDelivery().isTuesday(),
                service.getTransitTimes().get(0).getDelivery().isWednesday(),
                service.getTransitTimes().get(0).getDelivery().isThursday(),
                service.getTransitTimes().get(0).getDelivery().isFriday(),
                service.getTransitTimes().get(0).getDelivery().isSaturday()};

        int dispatchTime = service.getTransitTimes().get(0).getDispatch().getDuration();

        int transitTime = service.getTransitTimes().get(0).getTransit().getDuration();

        int deliveryTime = service.getTransitTimes().get(0).getDelivery().getDuration();

        System.out.println("Dispatch time: "+dispatchTime+"\nTransit time: "+transitTime+"\nDelivery time: "+deliveryTime);

        List<Date> deliveryDates = new ArrayList<>();

        while (dispatchTime > 0){
            System.out.println("Dispatch time: "+dispatchTime);
            if (availabilityDispatch[date.getDay()] && dispatchTime>0) {
                date.setDate(date.getDate()+1);
                dispatchTime--;
            } else {
                date.setDate(date.getDate()+1);
            }
        }

        while (transitTime >= 0){
            if (availabilityTransit[date.getDay()] && transitTime>=0) {
                deliveryDates.add(new Date(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), date.getMinutes()));
                System.out.println(date);
                date.setDate(date.getDate()+1);
                transitTime--;
            } else {
                date.setDate(date.getDate()+1);
            }
        }

        for (int i=0; i<deliveryDates.size(); i++){
            while(deliveryTime > 0){
                if (availabilityDelivery[deliveryDates.get(i).getDay()] && deliveryTime>0) {
                    System.out.println(deliveryDates.get(i));
                    deliveryDates.get(i).setDate(deliveryDates.get(i).getDate()+1);
                    deliveryTime--;
                } else {
                    deliveryDates.get(i).setDate(deliveryDates.get(i).getDate()+1);
                }
            }
            deliveryTime = service.getTransitTimes().get(0).getDelivery().getDuration();
        }

        return deliveryDates;
    }


    public Date stringToDate(String stringDate) {
        String day = "", month = "", year = "", hour = "", minute = "";

        for (int i=0; i<stringDate.length(); i++) {
            if (i==0 || i==1)
                day += stringDate.charAt(i);
            if (i==2 || i==3)
                month += stringDate.charAt(i);
            if (i==4 || i==5 || i==6 || i==7)
                year += stringDate.charAt(i);
            if (i==9 || i==10)
                hour += stringDate.charAt(i);
            if (i==11 || i==12)
                minute += stringDate.charAt(i);
        }

        Date newDate = new Date(Integer.parseInt(year)-1900, Integer.parseInt(month)-1, Integer.parseInt(day)+0, Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(day));
        return newDate;
    }
}
