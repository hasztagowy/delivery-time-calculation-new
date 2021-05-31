package com.studenci.apkameta.transit;

import com.studenci.apkameta.DeliveryWindow.DeliveryWindow;
import com.studenci.apkameta.Service.ServiceServiceImpl;
import com.studenci.apkameta.modules.Module;
import com.studenci.apkameta.modules.ModuleEntityRepositoryImpl;
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
    public TransitTimeController(ModuleEntityRepositoryImpl moduleEntityRepositoryImpl,
                                 ServiceServiceImpl serviceServiceImpl){
        this.moduleEntityRepositoryImpl = moduleEntityRepositoryImpl;
        this.serviceServiceImpl = serviceServiceImpl;
    }
//    ?serviceName&purchaseDate&fromCountry&toCountry
//    @RequestParam String pucharseDate, @RequestParam String fromCountry, @RequestParam String toCountry


    @GetMapping("/{moduleCode}/transitTimes")
    public String getCode(@PathVariable("moduleCode") String moduleCode, @RequestParam String serviceName,
                          @RequestParam String purchaseDate, @RequestParam String fromCountry, @RequestParam String toCountry){

        Module module = moduleEntityRepositoryImpl.getModuleByCode(moduleCode);
        TransitTime transitTimeObject = serviceServiceImpl.getTransitTimes(fromCountry, toCountry);
        Date date = stringToDate(purchaseDate);
        DeliveryWindow deliveryWindow = module.getDeliveryWindow();

        boolean[] availabilityDispatch = {transitTimeObject.getDispatch().isSunday(),
                transitTimeObject.getDispatch().isMonday(),
                transitTimeObject.getDispatch().isTuesday(),
                transitTimeObject.getDispatch().isWednesday(),
                transitTimeObject.getDispatch().isThursday(),
                transitTimeObject.getDispatch().isFriday(),
                transitTimeObject.getDispatch().isSaturday()};

        boolean[] availabilityTransit = {transitTimeObject.getTransit().isSunday(),
                transitTimeObject.getTransit().isMonday(),
                transitTimeObject.getTransit().isTuesday(),
                transitTimeObject.getTransit().isWednesday(),
                transitTimeObject.getTransit().isThursday(),
                transitTimeObject.getTransit().isFriday(),
                transitTimeObject.getTransit().isSaturday()};

        boolean[] availabilityDelivery = {transitTimeObject.getDelivery().isSunday(),
                transitTimeObject.getDelivery().isMonday(),
                transitTimeObject.getDelivery().isTuesday(),
                transitTimeObject.getDelivery().isWednesday(),
                transitTimeObject.getDelivery().isThursday(),
                transitTimeObject.getDelivery().isFriday(),
                transitTimeObject.getDelivery().isSaturday()};

        int dispatchTime = transitTimeObject.getDispatch().getDuration();
        int transitTime = transitTimeObject.getTransit().getDuration();
        int deliveryTime = transitTimeObject.getDelivery().getDuration();
        List<Date> deliveryDates = new ArrayList<>();
        boolean hourCheck = false;

        while (dispatchTime > 0){
            if ((date.getHours() > Integer.parseInt(module.getDeliveryWindow().getToH())) && !hourCheck){
                date.setDate(date.getDate() + 1);
                date.setHours(Integer.parseInt(module.getDeliveryWindow().getToH()));
                date.setMinutes(Integer.parseInt(module.getDeliveryWindow().getToM()));
                hourCheck = true;
            }
            if (availabilityDispatch[date.getDay()] && dispatchTime>0) {
                date.setDate(date.getDate()+1);
                dispatchTime--;
            } else {
                date.setDate(date.getDate()+1);
            }
        }

        while (transitTime >= 0){
            if (availabilityTransit[date.getDay()] && transitTime>=0) {
                if (transitTime == transitTimeObject.getTransit().getDuration()){
                    deliveryDates.add(new Date(date.getYear(), date.getMonth(), date.getDate(),
                            Integer.parseInt(module.getDeliveryWindow().getFromH()), Integer.parseInt(module.getDeliveryWindow().getFromM())));
                } else {
                    deliveryDates.add(new Date(date.getYear(), date.getMonth(), date.getDate(),
                            Integer.parseInt(module.getDeliveryWindow().getToH()), Integer.parseInt(module.getDeliveryWindow().getToM())));
                }
                date.setDate(date.getDate()+1);
                transitTime--;
            } else {
                date.setDate(date.getDate()+1);
            }
        }

        for (int i=0; i<deliveryDates.size(); i++) {
            while (deliveryTime >= 0) {
                if (availabilityDelivery[deliveryDates.get(i).getDay()] && deliveryTime > 0) {
                    deliveryDates.get(i).setDate(deliveryDates.get(i).getDate() + 1);
                    deliveryTime--;
                } else if (availabilityDelivery[deliveryDates.get(i).getDay()] && deliveryTime == 0) {
                    break;
                } else {
                    deliveryDates.get(i).setDate(deliveryDates.get(i).getDate() + 1);
                }
            }
            deliveryTime = transitTimeObject.getDelivery().getDuration();
        }

        List<String> deliveryDatesFrom = new ArrayList<>();
        List<String> deliveryDatesTo = new ArrayList<>();

        for (int i=0; i<deliveryDates.size(); i++) {
            deliveryDates.get(i).setHours(Integer.parseInt(deliveryWindow.getFromH()));
            deliveryDates.get(i).setMinutes(Integer.parseInt(deliveryWindow.getFromM()));
            deliveryDatesFrom.add(dateToString(deliveryDates.get(i)));
        }

        for (int i=0; i<deliveryDates.size(); i++) {
            deliveryDates.get(i).setHours(Integer.parseInt(deliveryWindow.getToH()));
            deliveryDates.get(i).setMinutes(Integer.parseInt(deliveryWindow.getToM()));
            deliveryDatesTo.add(dateToString(deliveryDates.get(i)));
        }

        List<PredictableDate> predictableDate = new ArrayList<>();

        for (int i=0; i<deliveryDates.size(); i++) {
            predictableDate.add(new PredictableDate(deliveryDatesFrom.get(i), deliveryDatesTo.get(i)));
        }

        PredictableDates predictableDates = new PredictableDates(purchaseDate, predictableDate);

        return predictableDates.toString();
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

        return new Date(Integer.parseInt(year)-1900, Integer.parseInt(month)-1, Integer.parseInt(day)+0, Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(day));
    }

    public String dateToString(Date date) {

        if (date.getMonth()<9 && date.getDate()<10 && date.getHours()<10) {
            return "0" + date.getDate() + "0" + (date.getMonth()+1) + (date.getYear()+1900) + "T0" + date.getHours() + date.getMinutes() + "0";
        } else if (date.getDate()<10 && date.getHours()<10) {
            return "0" + date.getDate() + (date.getMonth()+1) + (date.getYear()+1900) + "T0" + date.getHours() + date.getMinutes() + "0";
        } else if (date.getMonth()<9 && date.getHours()<10){
            return date.getDate() + "0" + (date.getMonth()+1) + (date.getYear()+1900) + "T0" + date.getHours() + date.getMinutes() + "0";
        } else if (date.getMonth()<9){
            return date.getDate() + "0" + (date.getMonth()+1) + (date.getYear()+1900) + "T" + date.getHours() + date.getMinutes() + "0";
        } else if (date.getDate()<10){
            return "0" + date.getDate() + (date.getMonth()+1) + (date.getYear()+1900) + "T0" + date.getHours() + date.getMinutes() + "0";
        } else if (date.getHours()<10){
            return "" + date.getDate() + (date.getMonth()+1) + (date.getYear()+1900) + "T0" + date.getHours() + date.getMinutes() + "0";
        } else {
            return "" + date.getDate() + (date.getMonth()+1) + (date.getYear()+1900) + "T" + date.getHours() + date.getMinutes() + "0";
        }
    }
}
