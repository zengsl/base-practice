package com.practice.spi.impl;

import com.alibaba.dubbo.common.extension.SPI;
import com.practice.spi.Robot;

/**
 * @author zengsl
 * @version V1.0
 * @date 2022/1/26 10:15 AM
 */
public class OptimusPrime implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Optimus Prime.");
    }
}