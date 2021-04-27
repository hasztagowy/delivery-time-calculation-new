package com.studenci.apkameta.users;

import org.springframework.stereotype.Service;

public interface UserService {
    boolean login(LoginDto user);

    User save(User user);
}
