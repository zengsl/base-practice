package com.practice.spi;

import org.junit.Test;

import java.net.URL;
import java.util.ServiceLoader;

/**
 * https://dubbo.apache.org/zh/docs/v2.7/dev/source/dubbo-spi/
 * @author zengsl
 * @version V1.0
 * @date 2022/1/26 10:26 AM
 */
public class JavaSPITest {

    @Test
    public void sayHello() throws Exception {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}
