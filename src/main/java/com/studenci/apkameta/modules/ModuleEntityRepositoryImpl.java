package com.studenci.apkameta.modules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ModuleEntityRepositoryImpl {

    @Autowired
    ModuleEntityRepository moduleEntityRepository;

    public Module getModuleByCode(String code){
        List<Module> allModules = moduleEntityRepository.findAll();
        Module moduleByCode = null;
        for (int i=0; i<allModules.size(); i++){
            if (allModules.get(i).getCode().equals(code)) {
                moduleByCode = allModules.get(i);
            }
        }
        return moduleByCode;
    }
}
