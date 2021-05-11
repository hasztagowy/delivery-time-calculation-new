package com.studenci.apkameta.users;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserControler {

    @Autowired
    UserDto userDto;

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
    public String login(@RequestBody LoginDto user) {

        if(userService.login(user)) {
            User user1= userDto.findTopByUsername((user.getUsername()));
            Long now = System.currentTimeMillis();
            String token =  Jwts.builder()
                    .setSubject(user.getUsername()) // 1
                    .claim("role", user1.getRole()) // 2
                    .setIssuedAt(new Date(now)) // 3
                    .setExpiration(new Date(now + 10000)) // 4
                    .signWith(SignatureAlgorithm.HS512, "secretkey").compact(); // 5
            return token;
        }
        return "blad";
    }

//    @PostMapping("/authorize")
//    public String authorizeUser(@RequestBody LoginDto user){
//        userService.login(user);
//        return "wuitam";
//    }
}
