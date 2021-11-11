package com.practice.pattern.composite.safe;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 2:54 下午
 */
//树叶构件
class Leaf implements Component {
    private String name;
    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("树叶" + name + "：被访问！");
    }
}