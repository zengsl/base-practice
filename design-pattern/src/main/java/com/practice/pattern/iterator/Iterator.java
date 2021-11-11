package com.practice.pattern.iterator;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 3:30 下午
 */
//抽象迭代器
interface Iterator {
    Object first();
    Object next();
    boolean hasNext();
}