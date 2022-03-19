package com.fan;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

public class TestAuthenticator {
    public static void main(String[] args) {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(new IniRealm("classpath:shiro.ini"));
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("fan", "123");
        try {
            System.out.println("认证状态："+subject.isAuthenticated());
            subject.login(token);
            System.out.println("认证状态："+subject.isAuthenticated());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
