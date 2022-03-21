package com.fan;

import com.fan.MyRealm.CustomerRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class TestCustomerRealm {
    public static void main(String[] args) {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(new CustomerRealm());
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("fan","123");
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误");
        } catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误");
        }
    }
}
