package com.practice.java.debugger;

import java.util.concurrent.TimeUnit;

/**
 * @author zengsl
 * @version V1.0
 * @date 2022/1/14 2:13 PM
 */
public class DebuggerTest {
private String name;
    public static void main(String[] args) throws InterruptedException {
        /*for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1");
            }
        }).start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(2));
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2");
            }
        }).start();

    }
}
