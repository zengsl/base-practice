package com.practice.pattern.chainOfResponsibility;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 3:08 下午
 */
//抽象处理者角色
abstract class Handler {
    private Handler next;
    public void setNext(Handler next) {
        this.next = next;
    }
    public Handler getNext() {
        return next;
    }
    //处理请求的方法
    public abstract void handleRequest(String request);
}