package com.fan;

import org.apache.shiro.crypto.hash.Md5Hash;

public class TestShiroMd5 {
    public static void main(String[] args) {
        //Md5Hash是shiro自带的md5加密
        //source是要加密的密码，salt是加盐处理
        Md5Hash md5Hash = new Md5Hash("fan", "!@");
        //toHex()方法是输出加密后的md5值
        System.out.println(md5Hash.toHex());

        Md5Hash md5Hash1 = new Md5Hash("fan1", "!@");
        System.out.println(md5Hash1.toHex());

        //md5 + salt + hash散列
        //hashlterations代表对结果散列多少次
        Md5Hash md5Hash2 = new Md5Hash("123", "!@", 1024);
        System.out.println(md5Hash2.toHex());
    }
}
