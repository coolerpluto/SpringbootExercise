package com.fan.springboot_jsp_shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/order")
@Controller
public class OrderController {

//    @RequiresRoles("admin")
    @RequiresPermissions("order:*:01")
    @RequestMapping("/a")
    public String order(){
        System.out.println("进入order");
        return "redirect:/index.jsp";
    }
}
