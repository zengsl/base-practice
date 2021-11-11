package com.practice.bytecode.instrument.agent;

import com.practice.bytecode.instrument.TestTransformer;

import java.lang.instrument.Instrumentation;

;

/**
 * https://tech.meituan.com/2019/09/05/java-bytecode-enhancement.html
 *
 * 手动打jar的方式jar -cvfm agentTest.jar [META-INF/MANIFEST.MF]  TestAgent.class
 * <p>
 * MANIFEST.MF需要配置好
 * <manifestEntries>
 * <Agent-Class>com.practice.bytecode.instrument.agent.TestAgent</Agent-Class>
 * <Can-Redefine-Classes>true</Can-Redefine-Classes>
 * <Can-Retransform-Classes>true</Can-Retransform-Classes>
 * </manifestEntries>
 * <p>
 * * JDK6之后允许运行时重载类，之前instrument只能在JVM刚启动开始加载类时生效 。需要结合premain方法。JDK6之后增加了agentmain
 * 区别:
 *
 *  编写：方法名和MANIFEST中配置的是premain还是agentmain
 *  运行：
 *      premain:java -javaagent:代理Jar包的路径 [=传入premain的参数] yourTarget.jar 主要是在运行时配置-javaagent:
 *      agentmain:通过attach API
 * @author zengsl
 * @version V1.0
 * @date 2021/10/21 5:47 下午
 */
public class TestAgent {

    public static void agentmain(String args, Instrumentation inst) {
        //指定我们自己定义的Transformer，在其中利用Javassist做字节码替换
        inst.addTransformer(new TestTransformer(), true);
        try {
            //重定义类并载入新的字节码
            inst.retransformClasses(Class.forName("com.practice.bytecode.instrument.Base"));
            System.out.println("Agent Load Done.");
        } catch (Exception e) {
            System.out.println("agent load failed!");
        }
    }
}
