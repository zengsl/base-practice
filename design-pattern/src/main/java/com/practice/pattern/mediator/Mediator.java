package com.practice.pattern.mediator;

/**
 * //抽象中介者
 *
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 3:20 下午
 */
public
abstract class Mediator {
    public abstract void register(Colleague colleague);
    public abstract void relay(Colleague cl); //转发
}