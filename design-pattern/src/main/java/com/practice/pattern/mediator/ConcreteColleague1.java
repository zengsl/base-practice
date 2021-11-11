package com.practice.pattern.mediator;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 3:22 下午
 */
//具体同事类
class ConcreteColleague1 extends Colleague {
    @Override
    public void receive() {
        System.out.println("具体同事类1收到请求。");
    }
    @Override
    public void send() {
        System.out.println("具体同事类1发出请求。");
        mediator.relay(this); //请中介者转发
    }
}