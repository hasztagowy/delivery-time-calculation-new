package com.studenci.apkameta.transit;

import com.studenci.apkameta.modules.Module;
import com.studenci.apkameta.users.UserControler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class TranisitTimeController {

//?serviceName&purchaseDate&fromCountry&toCountry
    @RequestMapping(value = "/{code}/transitTimes", method = RequestMethod.GET)
    public String getCode(@PathVariable("code") String code, @RequestParam String serviceName, @RequestParam String purchaseDate,
                   @RequestParam String fromCountry, @RequestParam String toCountry){
        if(code.equals("ee")){
            return "hej";
        }

        return "dd";
    }







}
