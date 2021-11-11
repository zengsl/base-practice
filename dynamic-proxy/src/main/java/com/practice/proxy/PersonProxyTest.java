package com.practice.proxy;

import java.lang.reflect.Proxy;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/11/6 10:23 上午
 */
public class PersonProxyTest {

    public static void main(String[] args) {
        PersonService personService = (PersonService) Proxy.newProxyInstance(PersonProxyTest.class.getClassLoader(), new Class[]{PersonService.class}, (proxy, method, args1) -> {
            System.out.println("hello");
            return null ;
        });
        personService.sayHello();
    }
}
