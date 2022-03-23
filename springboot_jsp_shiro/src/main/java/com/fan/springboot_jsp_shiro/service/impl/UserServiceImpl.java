package com.fan.springboot_jsp_shiro.service.impl;

import com.fan.springboot_jsp_shiro.MyUtils.SaltUtil;
import com.fan.springboot_jsp_shiro.dao.UserDao;
import com.fan.springboot_jsp_shiro.pojo.User;
import com.fan.springboot_jsp_shiro.service.UserService;
import org.apache.shiro.crypto.hash.Md2Hash;
import org.apache.shiro.crypto.hash.Md5Hash;
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
        Md5Hash md5Hash = new Md5Hash(user.getPassword(),salt,1024);
        user.setPassword(md5Hash.toHex());
        userDao.insert(user);
    }

    @Override
    public User getUserByName(String userName) {
        return userDao.getUserByName(userName);
    }

    @Override
    public User getUserRoles(String userName) {
        return userDao.getUserRoles(userName);
    }
}
