package com.studenci.apkameta.transit;

import com.studenci.apkameta.modules.Module;
import com.studenci.apkameta.users.UserControler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransitTimeController {

//?serviceName&purchaseDate&fromCountry&toCountry
//    @RequestMapping(value = "/{code}/transitTimes", method = RequestMethod.GET)
//    public String getCode(@PathVariable("code") String code, @RequestParam String serviceName, @RequestParam String purchaseDate,
//                   @RequestParam String fromCountry, @RequestParam String toCountry){
//        if(code.equals("ee")){
//            return "hej";
//        }
//
//        return "dd";
//    }


    @GetMapping(value = "/{moduleCode}/transitTimes")
    public String getCode(@PathVariable("moduleCode") String moduleCode) {
        if (moduleCode.equals("DHL")) {
            return "moduleCode is DHL";
        } else if(moduleCode.equals("GLS"))
            return "moduleCode is GLS";
        return "moduleCode is incorrect";
    }






}
