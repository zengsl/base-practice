package com.practice.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 3:30 下午
 */
//具体聚合
class ConcreteAggregate implements Aggregate {
    private List<Object> list = new ArrayList<Object>();

    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(Object obj) {
        list.remove(obj);
    }

    @Override
    public Iterator getIterator() {
        return (new ConcreteIterator(list));
    }
}
