package com.studenci.apkameta;

import com.studenci.apkameta.users.Role;
import com.studenci.apkameta.users.User;
import com.studenci.apkameta.users.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Config {
    @Bean
    CommandLineRunner commandLineRunner(UserService userService) {
        return args -> {
            User user = new User("user1", "haslo", Role.USER);
            User admin = new User("testadmin", "password", Role.ADMIN);
            userService.save(user);
            userService.save(admin);
        };
    }
}
