package com.studenci.apkameta.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDto extends JpaRepository<User,Long> {
    User findTopByUsername(String userName);

}
