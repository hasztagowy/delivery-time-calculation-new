package com.studenci.apkameta.modules;

import com.studenci.apkameta.users.LoginDto;
import com.studenci.apkameta.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ModuleControler {

    @Autowired
    ModuleEntityRepository moduleEntityRepository;




//    @PostMapping(value = "/modules")
//    public void modules(@RequestBody LoginDto user){
//        if (moduleService.verify(user))
//            System.out.println("dziala");
//    }

    @GetMapping("/modules")
    public void helloo(){
      //  Module newModule=new Module("kod");
       // moduleEntityRepository.save(newModule);
        System.out.println("hello");
    }

    @PostMapping("/modules")

    String komunkat(@RequestBody Module newModule) {
        moduleEntityRepository.save(newModule);
        return "ok";
    }

    @DeleteMapping("/modules")
    public String hello(){
        return "hello";
    }


}

