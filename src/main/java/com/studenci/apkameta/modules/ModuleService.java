package com.studenci.apkameta.modules;

import com.studenci.apkameta.users.LoginDto;
import com.studenci.apkameta.users.User;
import org.springframework.stereotype.Service;


public interface ModuleService {

    boolean verify(LoginDto user);
}
