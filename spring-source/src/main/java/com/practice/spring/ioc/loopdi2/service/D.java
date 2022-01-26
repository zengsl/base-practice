package com.practice.spring.ioc.loopdi2.service;

import org.springframework.stereotype.Service;

/**
 * @author zengsl
 * @version V1.0
 * @date 2022/1/7 2:42 PM
 */
@Service
public class D {
    private C c;
    public D(C c) {
        this.c = c;
    }
}
