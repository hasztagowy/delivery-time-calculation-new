package com.studenci.apkameta.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControler {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/")
    public String elo(){
        return "elo";
    }

    @PostMapping("/reg")
    public String reg(@RequestBody User user){
        userService.save(user);
        return "wuitam";
    }


    @PostMapping("/authorize")
    public String authorizeUser(@RequestBody LoginDto user){
        userService.login(user);
        return "wuitam";
    }
}
