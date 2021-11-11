package com.practice.bytecode.javaassist;

import javassist.*;

import java.io.IOException;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/21 5:14 下午
 */
public class JavassistTest {

    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, IOException {
        //new Base(); // 打开则报错，JVM是不允许在运行时动态重载一个类的
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.practice.bytecode.javaassist.Base");
        CtMethod m = cc.getDeclaredMethod("process");
        m.insertBefore("{ System.out.println(\"start\"); }");
        m.insertAfter("{ System.out.println(\"end\"); }");
        Class<?> c = cc.toClass();
        cc.writeFile("dynamic-proxy/target/classes/");
        Base h = (Base) c.newInstance();
        h.process();
    }
}
