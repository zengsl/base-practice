package com.practice.pattern.vistor.service;


import com.practice.pattern.vistor.service.impl.Monitor;
import com.practice.pattern.vistor.service.impl.Mouse;
import com.practice.pattern.vistor.service.impl.Computer;
import com.practice.pattern.vistor.service.impl.Keyboard;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/21 4:17 下午
 */
public interface ComputerPartVisitor {

    void visit(Computer computer);
    void visit(Mouse mouse);
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
}
