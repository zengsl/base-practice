package com.practice.proxy.source;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * https://zhuanlan.zhihu.com/p/442078550
 *
 * 生成的代类在项目根目录下，如：/Users/zengsl/Project/study/base-practice/com/practice/proxy/source
 * @author zengsl
 * @version V1.0
 * @date 2021/12/7 1:33 下午
 */
public class ProxyDemo {
    public static void main(String[] args) throws Exception {
        // 将创建的代理类$Proxy0的字节码保存
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // 创建回调函数
        InvocationHandler handler = new MyInvocationHandler();
        // 创建代理类
        Class<?> proxyClass = Proxy.getProxyClass(Foo.class.getClassLoader(), Foo.class);
        // 生成代理对象
        Foo f = (Foo) proxyClass.getConstructor(InvocationHandler.class).newInstance(handler);
        f.foo(); // 调用代理对象方法
    }

    // 回调处理器
    private static class MyInvocationHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(method.getName());
            return null;
        }
    }

    private interface Foo {
        void foo();
    }

   /* private interface Foo {
        Object foo();
    }

    private interface Foo2 {
        Foo foo();
    }*/
}