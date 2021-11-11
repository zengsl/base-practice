package com.practice.pattern.flyweight;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 2:47 下午
 */
//抽象享元角色
interface Flyweight {
    public void operation(UnsharedConcreteFlyweight state);
}