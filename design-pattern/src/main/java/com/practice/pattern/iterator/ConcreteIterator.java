package com.practice.pattern.iterator;

import java.util.List;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 3:30 下午
 */
//具体迭代器
class ConcreteIterator implements Iterator {
    private final List<Object> list;
    private int index = -1;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size() - 1;
    }

    @Override
    public Object first() {
        index = 0;
        Object obj = list.get(index);
        return obj;
    }

    @Override
    public Object next() {
        Object obj = null;
        if (this.hasNext()) {
            obj = list.get(++index);
        }
        return obj;
    }
}