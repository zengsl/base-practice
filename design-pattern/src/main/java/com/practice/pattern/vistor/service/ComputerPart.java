package com.practice.pattern.vistor.service;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/21 4:15 下午
 */
public interface ComputerPart {

    void accept(ComputerPartVisitor computerPartVisitor);

}
