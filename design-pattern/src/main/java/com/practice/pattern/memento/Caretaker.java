package com.practice.pattern.memento;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 4:14 下午
 */

//管理者
class Caretaker {
    private Memento memento;
    public void setMemento(Memento m) {
        memento = m;
    }
    public Memento getMemento() {
        return memento;
    }
}