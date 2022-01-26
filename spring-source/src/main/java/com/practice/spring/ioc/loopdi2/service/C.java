package com.practice.spring.ioc.loopdi2.service;

import org.springframework.stereotype.Service;

/**
 * @author zengsl
 * @version V1.0
 * @date 2022/1/7 2:41 PM
 */
@Service
public class C {

    private D d;

    public C(D d) {
        this.d = d;
    }
}
