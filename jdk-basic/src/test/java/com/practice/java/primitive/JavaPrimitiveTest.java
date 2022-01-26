package com.practice.java.primitive;

import org.junit.Test;

/**
 * @author zengsl
 * @version V1.0
 * @date 2022/1/10 3:02 PM
 */
public class JavaPrimitiveTest {

    @Test
    public void mathRound() {
        System.out.println(Math.round(15.5));
        System.out.println(Math.round(-15.5));
        float f = (float) 3.4; // 浮点型字面量的类型是double
        float f2 =  3.4F;

        short s1 = 1;
        //s1 = s1 + 1; // 整型字面量的类型是int，所以s1+1是一个int类型，需要强制转换
        s1 = (short) (s1 + 1);
        s1 +=1; // += 包含隐含的强制类型转换，相当于 s1 = (short(s1 + 1);

        // float 是4个字节， 1位符号位，8位指数位，23位尾数位
        // 指数：8个指数位最大范围为0～255 实际的指数是包含小数的，所以还要-127才是最终的指数值
        // 尾数：高位的1隐藏，不存入尾数位中。当指数位为0时，隐藏的高位为0。



    }

}
