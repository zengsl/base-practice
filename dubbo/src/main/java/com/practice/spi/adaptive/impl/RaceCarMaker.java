package com.practice.spi.adaptive.impl;

import com.alibaba.dubbo.common.URL;
import com.practice.spi.adaptive.*;

/**
 * @author zengsl
 * @version V1.0
 * @date 2022/1/26 11:54 AM
 */
public class RaceCarMaker implements CarMaker {
    WheelMaker wheelMaker;

    // 通过 setter 注入 AdaptiveWheelMaker
    public void setWheelMaker(WheelMaker wheelMaker) {
        this.wheelMaker = wheelMaker;
    }

    public Car makeCar(URL url) {
        Wheel wheel = wheelMaker.makeWheel(url);
        return new RaceCar(wheel);
    }
}
