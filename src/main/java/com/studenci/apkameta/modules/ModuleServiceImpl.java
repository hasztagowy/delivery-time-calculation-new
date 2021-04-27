package com.studenci.apkameta.modules;

import com.studenci.apkameta.users.LoginDto;
import com.studenci.apkameta.users.User;
import com.studenci.apkameta.users.UserService;
import org.springframework.stereotype.Service;

@Service
public class ModuleService implements UserService {
    @Override
    public boolean login(LoginDto user) {
        return false;
    }

    @Override
    public User save(User user) {
        return null;
    }
}
