package com.practice.bytecode.instrument;

import java.lang.management.ManagementFactory;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/21 4:56 下午
 */
public class Base {

    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String s = name.split("@")[0];
        //打印当前Pid
        System.out.println("pid:" + s);
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (Exception e) {
                break;
            }
            process();
        }
    }

    public static void process() {
        System.out.println("process");
    }
}
