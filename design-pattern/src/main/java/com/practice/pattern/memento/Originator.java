package com.practice.pattern.memento;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 4:14 下午
 */
//发起人
class Originator {
    private String state;
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
    public Memento createMemento() {
        return new Memento(state);
    }
    public void restoreMemento(Memento m) {
        this.setState(m.getState());
    }
}
