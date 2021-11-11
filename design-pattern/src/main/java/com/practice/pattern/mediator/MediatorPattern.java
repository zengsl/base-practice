package com.practice.pattern.mediator;

/**
 * 中介者模式
 *
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 3:22 下午
 */
public class MediatorPattern {

    public static void main(String[] args) {
        Mediator md = new ConcreteMediator();
        Colleague c1, c2;
        c1 = new ConcreteColleague1();
        c2 = new ConcreteColleague2();
        md.register(c1);
        md.register(c2);
        c1.send();
        System.out.println("-------------");
        c2.send();
    }
}
