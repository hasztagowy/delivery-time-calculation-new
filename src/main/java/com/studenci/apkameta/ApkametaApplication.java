package com.studenci.apkameta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ApkametaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApkametaApplication.class, args);
    }

//    @Bean
//    public FilterRegistrationBean filterForModules() {
//        FilterRegistrationBean filterForModules = new FilterRegistrationBean();
//        filterForModules.setFilter(new JwtFilterModules());
//        filterForModules.setUrlPatterns(Collections.singleton("/modules/*"));
//        return filterForModules;
//    }

//    @Bean
//    public FilterRegistrationBean filterForTransitTime() {
//        FilterRegistrationBean filterForTransitTime = new FilterRegistrationBean();
//        filterForTransitTime.setFilter(new JwtFilterGetTransitTime());
//        filterForTransitTime.setUrlPatterns(Arrays.asList("/DHL/*", "/GLS/*"));
//        return filterForTransitTime;
//    }

}
