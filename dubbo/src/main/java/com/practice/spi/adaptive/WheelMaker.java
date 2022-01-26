package com.practice.spi.adaptive;

import com.alibaba.dubbo.common.URL;

/**
 * @author zengsl
 * @version V1.0
 * @date 2022/1/26 11:48 AM
 */
public interface WheelMaker {
    Wheel makeWheel(URL url);
}