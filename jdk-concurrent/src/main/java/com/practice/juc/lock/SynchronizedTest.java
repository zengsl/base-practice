package com.practice.juc.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/28 9:20 上午
 */
public class SynchronizedTest {
    // 修饰方法是通过ACC_SYNCHRONIZED标识
    public synchronized void sayHello() {
        // 代码块在字节码层面是通过MONITORENTER和MONITOREXIT两个指令实现
        synchronized (this) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hello");
    }

    // 修饰方法是通过ACC_SYNCHRONIZED标识
    public static synchronized void sayHelloStatic() {
        System.out.println("Hello");

    }

    public static void main(String[] args) {
        new SynchronizedTest().sayHello();
    }
}
