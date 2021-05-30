package com.studenci.apkameta.transit;

import com.studenci.apkameta.modules.Module;
import com.studenci.apkameta.modules.ModuleEntityRepository;
import com.studenci.apkameta.modules.ModuleEntityRepositoryImpl;
import com.studenci.apkameta.users.UserControler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TransitTimeController {

    ModuleEntityRepositoryImpl moduleEntityRepositoryImpl;
    public TransitTimeController(ModuleEntityRepositoryImpl moduleEntityRepositoryImpl){
        this.moduleEntityRepositoryImpl = moduleEntityRepositoryImpl;
    }
    //?serviceName&purchaseDate&fromCountry&toCountry

    @GetMapping("/{moduleCode}/transitTimes")
    public String getCode(@PathVariable("moduleCode") String moduleCode){

        Module module = moduleEntityRepositoryImpl.getModuleByCode(moduleCode);

        return module.toString();
//        if (moduleCode.equals("DHL")) {
//            return "moduleCode is "+module.getCode();
//        } else if(moduleCode.equals("GLS"))
//            return "moduleCode is GLS";
//        return "moduleCode is incorrect";
    }






}
