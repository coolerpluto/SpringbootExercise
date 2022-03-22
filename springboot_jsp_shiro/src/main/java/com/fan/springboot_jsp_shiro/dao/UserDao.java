package com.fan.springboot_jsp_shiro.dao;

import com.fan.springboot_jsp_shiro.pojo.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDao {
    void insert(User user);
}

