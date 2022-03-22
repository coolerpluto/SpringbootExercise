package com.fan.springboot_jsp_shiro.controller;

import com.fan.springboot_jsp_shiro.pojo.User;
import com.fan.springboot_jsp_shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(User user){
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
            return "redirect:/index.jsp";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名不存在");
        } catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误");
        }

        return "redirect:/login.jsp";
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login.jsp";
    }

    @RequestMapping("/register")
    public String register(User user){
        userService.register(user);
        return "redirect:/login.jsp";
    }
}
