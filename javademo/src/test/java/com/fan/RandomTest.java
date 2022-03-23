package com.fan;

import org.junit.Test;

import java.util.Random;

public class RandomTest {
    @Test
    public void test01(){
        //Math.random()默认返回double类型，float单精度，double双精度
        float random = (float)Math.random();
        System.out.println(random);
    }
    @Test
    public void test02(){
        for (int i=0; i < 4 ; i++){
            //nextBoolean()返回下一个伪随机数，它是取自此随机数生成器序列的均匀分布的 boolean值。
            System.out.println(new Random().nextBoolean());
            System.out.println(new Random().nextInt());
            System.out.println(new Random().nextInt(100));
            System.out.println("********");
        }

    }
}
