package com.practice.pattern.composite.simple;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 2:53 下午
 */
//抽象构件
interface Component {
    void add(Component c);
    void remove(Component c);
    Component getChild(int i);
    void operation();
}