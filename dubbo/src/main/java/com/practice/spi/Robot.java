package com.practice.spi;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author zengsl
 * @version V1.0
 * @date 2022/1/26 10:15 AM
 */
@SPI
public interface Robot {
    void sayHello();
}
