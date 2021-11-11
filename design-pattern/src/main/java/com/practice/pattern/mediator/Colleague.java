package com.practice.pattern.mediator;

/**
 * //抽象同事类
 *
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 3:21 下午
 */
public abstract class Colleague {
    protected Mediator mediator;

    public void setMedium(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive();

    public abstract void send();
}