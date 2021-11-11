package com.practice.pattern.vistor.service.impl;

import com.practice.pattern.vistor.service.ComputerPart;
import com.practice.pattern.vistor.service.ComputerPartVisitor;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/21 4:20 下午
 */
public class Computer implements ComputerPart {

    private final ComputerPart[] parts;

    public Computer(){
        parts = new ComputerPart[] {new Mouse(), new Keyboard(), new Monitor()};
    }


    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (ComputerPart part : parts) {
            part.accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}
