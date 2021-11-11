package com.practice.pattern.composite.simple;

import java.util.ArrayList;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 2:54 下午
 */
//树枝构件
class Composite implements Component {
    private ArrayList<Component> children = new ArrayList<Component>();
    @Override
    public void add(Component c) {
        children.add(c);
    }
    @Override
    public void remove(Component c) {
        children.remove(c);
    }
    @Override
    public Component getChild(int i) {
        return children.get(i);
    }
    @Override
    public void operation() {
        for (Object obj : children) {
            ((Component) obj).operation();
        }
    }
}