package com.studenci.apkameta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class ApkametaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApkametaApplication.class, args);
    }
/*
    @Bean
    public FilterRegistrationBean filterForModules() {
        FilterRegistrationBean filterForModules = new FilterRegistrationBean();
        filterForModules.setFilter(new JwtFilterModules());
        filterForModules.setUrlPatterns(Collections.singleton("/modules/*"));
        return filterForModules;
    }
*/
//    @Bean
//    public FilterRegistrationBean filterForTransitTime() {
//        FilterRegistrationBean filterForTransitTime = new FilterRegistrationBean();
//        filterForTransitTime.setFilter(new JwtFilter());
//        filterForTransitTime.setUrlPatterns(Collections.singleton("/{moduleCode}/*"));
//        return filterForTransitTime;
//    }

}
