package com.studenci.apkameta.users;


import com.studenci.apkameta.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDto userDto;

    @Override
    public boolean login(LoginDto user) {
        if(user.getUsername().isEmpty()){
            throw new UserNotFoundException();
        }
        if(userDto.findTopByUsername(user.getUsername())==null) {
            throw new UserNotFoundException();
        }
        User user1=userDto.findTopByUsername((user.getUsername()));
        if(!(user.getPassword().equals(user1.getPassword()))){
            throw  new UserNotFoundException();
        }
        return  true;
    }

    @Override
    public User save(User user) {
        userDto.save(user);
        return user;
    }
}
