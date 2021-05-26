package com.studenci.apkameta.users;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
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
            long currentTimeMillis = System.currentTimeMillis();
            return Jwts.builder()
                    .setSubject(user.getUsername())
                    .claim("role", user1.getRole())
                    .setIssuedAt(new Date(currentTimeMillis))
                    .setExpiration(new Date(currentTimeMillis + 40000))
                    .signWith(SignatureAlgorithm.HS512, "secretkey").compact(); // 5
        }
        return "blad";
    }
}
