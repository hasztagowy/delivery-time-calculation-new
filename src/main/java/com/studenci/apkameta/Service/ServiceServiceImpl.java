
package com.studenci.apkameta.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl{
    @Autowired
    ServiceService serviceService;

    public com.studenci.apkameta.Service.Service getServiceByName(String name) {
        List<com.studenci.apkameta.Service.Service> allServices = serviceService.findAll();
        com.studenci.apkameta.Service.Service serviceByName = null;
        for (int i=0; i<allServices.size(); i++){
            if (allServices.get(i).getName().equals(name)) {
                serviceByName = allServices.get(i);
            }
        }
        return serviceByName;
    }
}
