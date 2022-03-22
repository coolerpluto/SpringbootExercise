package com.fan.springboot_jsp_shiro.config;

import com.fan.springboot_jsp_shiro.realm.UserRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyShiroConfig {

    //配置shiro拦截器，负责拦截请求请求
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        Map<String,String> map = new HashMap<>();

        //设置公共资源请求，匿名访问，不需要认证授权的，通过anon
        map.put("/user/login", "anon");
        map.put("/register.jsp","anon");
        map.put("/user/register","anon");

        //设置受限资源，所有请求都设为受限资源，authc代表受限资源
        map.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    //配置安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("getRealm") Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }


    @Bean
    public Realm getRealm(){
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }
}
