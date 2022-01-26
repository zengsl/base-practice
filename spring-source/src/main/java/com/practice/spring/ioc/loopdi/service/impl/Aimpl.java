package com.practice.spring.ioc.loopdi.service.impl;

import com.practice.spring.ioc.loopdi.service.A;
import com.practice.spring.ioc.loopdi.service.B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zengsl
 * @version V1.0
 * @date 2022/1/7 2:23 PM
 */
@Service
public class Aimpl implements A {
    @Autowired
    private B b;

    @Override
    public void print() {
        System.out.println("This is Aimpl");
    }
}
