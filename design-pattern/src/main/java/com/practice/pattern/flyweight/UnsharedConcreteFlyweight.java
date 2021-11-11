package com.practice.pattern.flyweight;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 2:47 下午
 */
//非享元角色
class UnsharedConcreteFlyweight {
    private String info;
    UnsharedConcreteFlyweight(String info) {
        this.info = info;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
}