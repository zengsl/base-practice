package com.practice.basic;

import java.io.File;

/**
 *
 * @author zengsl
 * @version V1.0
 * @date 2021/11/13 7:58 下午
 */
public class Test {

    public static void main(String[] args) {
        // DEMO1
        String st1 = "Hello";
        String st2 = "Hello";
        System.out.println(st1 == st2);

        // demo2
        String hello = new String("Hello");
        System.out.println(hello == st1);
        System.out.println(hello.intern() == st1);

        // demo3
        String llopp = "llopp";
        String llo = "llo";
        String str3 = llo + "pp";
        String str4 = "llo" + "pp";

        System.out.println(llopp == str3);
        System.out.println(llopp == str4);
        String str5 = llo + "pp";
        System.out.println(str5 == str3);
    }
}
