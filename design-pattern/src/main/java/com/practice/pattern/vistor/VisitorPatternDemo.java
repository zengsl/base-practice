package com.practice.pattern.vistor;


import com.practice.pattern.vistor.service.ComputerPart;
import com.practice.pattern.vistor.service.impl.Computer;
import com.practice.pattern.vistor.service.impl.ComputerPartDisplayVisitor;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/21 4:23 下午
 */
public class VisitorPatternDemo {

    public static void main(String[] args) {

        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
