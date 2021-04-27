package com.studenci.apkameta.modules;

import com.studenci.apkameta.exception.BadRoleException;
import com.studenci.apkameta.exception.UserNotFoundException;
import com.studenci.apkameta.users.LoginDto;
import com.studenci.apkameta.users.Role;
import com.studenci.apkameta.users.User;
import com.studenci.apkameta.users.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    UserDto userDto;

    @Override
    public boolean verify(LoginDto user) {

        if(user.getUsername().isEmpty()){
            System.out.println("dupa");
            throw new UserNotFoundException();
        }
        if(userDto.findTopByUsername(user.getUsername())==null) {
            System.out.println("dupa");
            throw new UserNotFoundException();
        }
        User user1=userDto.findTopByUsername((user.getUsername()));
        System.out.println(user1.getRole());
        if(user1.getRole()!=Role.ADMIN){
            System.out.println("dupa");
            throw  new BadRoleException();
        }
        if(!(user.getPassword().equals(user1.getPassword()))){
            System.out.println("dupa");
            throw  new UserNotFoundException();
        }

        return  true;
    }
}
