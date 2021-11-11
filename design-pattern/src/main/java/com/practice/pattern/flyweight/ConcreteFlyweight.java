package com.practice.pattern.flyweight;

/**
 * 具体享元角色
 *
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 2:47 下午
 */
class ConcreteFlyweight implements Flyweight {
    private String key;

    ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println("具体享元" + key + "被创建！");
    }

    @Override
    public void operation(UnsharedConcreteFlyweight outState) {
        System.out.print("具体享元" + key + "被调用，");
        System.out.println("非享元信息是:" + outState.getInfo());
    }
}