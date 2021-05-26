package com.studenci.apkameta.modules;

import com.studenci.apkameta.users.LoginDto;


public interface ModuleService {

    boolean verify(LoginDto user);
    String createModule(Module module);
}
