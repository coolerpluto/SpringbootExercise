package com.fan.springboot_jsp_shiro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String userName;
    private String password;
    private String salt;
}
