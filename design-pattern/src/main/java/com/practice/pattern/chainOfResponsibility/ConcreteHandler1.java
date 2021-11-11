package com.practice.pattern.chainOfResponsibility;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 3:08 下午
 */
//具体处理者角色1
class ConcreteHandler1 extends Handler {
    @Override
    public void handleRequest(String request) {
        if ("one".equals(request)) {
            System.out.println("具体处理者1负责处理该请求！");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(request);
            } else {
                System.out.println("没有人处理该请求！");
            }
        }
    }
}