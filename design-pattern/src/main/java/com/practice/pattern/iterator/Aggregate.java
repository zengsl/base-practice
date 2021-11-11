package com.practice.pattern.iterator;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 3:29 下午
 */
//抽象聚合
interface Aggregate {
    public void add(Object obj);
    public void remove(Object obj);
    public Iterator getIterator();
}