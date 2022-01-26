package com.practice.spring.ioc;

import com.practice.spring.ioc.loopdi.service.A;
import com.practice.spring.ioc.loopdi.service.B;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zengsl
 * @version V1.0
 * @date 2022/1/7 2:20 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContextIocTest.xml"})
public class IocTest {

    @Autowired
    private A a;

    @Autowired
    private B b;

    @Test
    public void loopDependency() {
        a.print();
        b.print();


        System.out.println(-12340 >> 4);
    }


}
