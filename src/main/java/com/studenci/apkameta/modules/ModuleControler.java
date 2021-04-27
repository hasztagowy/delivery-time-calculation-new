package com.studenci.apkameta.modules;

import com.studenci.apkameta.users.LoginDto;
import com.studenci.apkameta.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModuleControler {
    @Autowired
    ModuleServiceImpl moduleService;

    @PostMapping(value = "/modules")
    public String modules(@RequestBody LoginDto user){
        moduleService.verify(user);
        return "ad";
    }
}
