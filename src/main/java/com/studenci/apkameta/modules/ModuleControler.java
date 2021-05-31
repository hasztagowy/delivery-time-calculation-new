package com.studenci.apkameta.modules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Module> helloo(){
      //  Module newModule=new Module("kod");
       // moduleEntityRepository.save(newModule);
//        System.out.println("hello");
        return moduleEntityRepository.findAll();
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

