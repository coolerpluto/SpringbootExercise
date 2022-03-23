package com.fan.springboot_jsp_shiro.service;

import com.fan.springboot_jsp_shiro.pojo.User;

public interface UserService {
    void register(User user);

    User getUserByName(String userName);

    User getUserRoles(String userName);
}
