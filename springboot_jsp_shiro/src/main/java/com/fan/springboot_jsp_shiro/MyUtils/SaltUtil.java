package com.fan.springboot_jsp_shiro.MyUtils;

import java.util.Random;

public class SaltUtil {
    public static String getSalt(int n){
        char[] chars = "QWERTYUIopasfhjh!@#$%".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            char achar = chars[new Random().nextInt(chars.length)];
            sb.append(achar);
        }
        return sb.toString();
    }
}
