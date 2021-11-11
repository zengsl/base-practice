package com.practice.pattern.vistor.service.impl;

import com.practice.pattern.vistor.service.ComputerPart;
import com.practice.pattern.vistor.service.ComputerPartVisitor;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/21 4:18 下午
 */
public class Keyboard implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
