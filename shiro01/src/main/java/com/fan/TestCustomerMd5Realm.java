package com.fan;

import com.fan.MyRealm.CustomerMd5Realm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

public class TestCustomerMd5Realm {
    public static void main(String[] args) {
        //创建安全管理器
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //配置自定义的realm，自定义账号密码获取方式
        CustomerMd5Realm customerMd5Realm = new CustomerMd5Realm();
        //new一个凭证管理器，设置加密方式为md5，散列次数1024。默认的凭证管理器是只有equals来比较密码，没有对传来的密码进行加密处理
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1024);
        //把这个凭证管理器放到自定义的realm
        customerMd5Realm.setCredentialsMatcher(hashedCredentialsMatcher);
        defaultSecurityManager.setRealm(customerMd5Realm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("fan","123");
        try {
            subject.login(token);
            System.out.println("登录成功");
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名不存在");
        } catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码不正确");
        }

        if(subject.isAuthenticated()){
            boolean admin = subject.hasRole("admin");
            boolean permitted = subject.isPermitted("user:update:01");
            System.out.println("该用户是否有admin角色"+admin);
            System.out.println("permitted："+permitted);
        }
    }
}
