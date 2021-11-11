package com.practice.pattern.chainOfResponsibility;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 3:09 下午
 */
public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        //组装责任链
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);
        //提交请求
        handler1.handleRequest("two");
    }
}
