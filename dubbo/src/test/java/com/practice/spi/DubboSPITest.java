package com.practice.spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

import java.net.URL;
import java.util.ServiceLoader;

/**
 * https://dubbo.apache.org/zh/docs/v2.7/dev/source/dubbo-spi/
 * @author zengsl
 * @version V1.0
 * @date 2022/1/26 10:26 AM
 */
public class DubboSPITest {

    @Test
    public void sayHello() throws Exception {
        ExtensionLoader<Robot> extensionLoader =
                ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}
