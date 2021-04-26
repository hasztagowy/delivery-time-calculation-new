package com.studenci.apkameta.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class UserControler {


    @PostMapping("/authorize")
    public String authorizeUser(User user){

        return "z";

    }
}
