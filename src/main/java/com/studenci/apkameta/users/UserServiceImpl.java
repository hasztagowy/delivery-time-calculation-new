package com.studenci.apkameta.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDto userDto;

    @Override
    public boolean login(LoginDto user) {
        User user1= userDto.findTopByUsername(user.getUsername());
        if(user1.getUsername()==null){
            throw new RuntimeException("user not found");
        }
        if(!(user.getPassword().equals(user1.getPassword()))){
            throw  new RuntimeException("wrong password");
        }
        return  true;
    }

    @Override
    public User save(User user) {
        userDto.save(user);
        return user;
    }
}
