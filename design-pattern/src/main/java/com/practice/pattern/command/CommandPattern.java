package com.practice.pattern.command;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 3:03 下午
 */
public class CommandPattern {
    public static void main(String[] args) {
        Command cmd = new ConcreteCommand();
        Invoker ir = new Invoker(cmd);
        System.out.println("客户访问调用者的call()方法...");
        ir.call();
    }
}