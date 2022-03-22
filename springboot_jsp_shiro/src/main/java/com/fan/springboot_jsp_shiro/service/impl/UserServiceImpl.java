package com.fan.springboot_jsp_shiro.service.impl;

import com.fan.springboot_jsp_shiro.MyUtils.SaltUtil;
import com.fan.springboot_jsp_shiro.dao.UserDao;
import com.fan.springboot_jsp_shiro.pojo.User;
import com.fan.springboot_jsp_shiro.service.UserService;
import org.apache.shiro.crypto.hash.Md2Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void register(User user) {
        String salt = SaltUtil.getSalt(4);
        user.setSalt(salt);
        Md2Hash md2Hash = new Md2Hash(user.getPassword(),salt,1024);
        user.setPassword(md2Hash.toHex());
        userDao.insert(user);
    }
}
