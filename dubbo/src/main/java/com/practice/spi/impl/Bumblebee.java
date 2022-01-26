package com.practice.spi.impl;

import com.alibaba.dubbo.common.extension.SPI;
import com.practice.spi.Robot;

/**
 * @author zengsl
 * @version V1.0
 * @date 2022/1/26 10:16 AM
 */
public class Bumblebee implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}