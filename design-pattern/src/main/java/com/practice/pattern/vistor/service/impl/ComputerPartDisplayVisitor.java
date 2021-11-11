package com.practice.pattern.vistor.service.impl;


import com.practice.pattern.vistor.service.ComputerPartVisitor;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/21 4:23 下午
 */
public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

    @Override
    public void visit(Computer computer) {
        System.out.println("Displaying Computer.");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Displaying Mouse.");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Displaying Keyboard.");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Displaying Monitor.");
    }
}
