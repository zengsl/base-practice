package com.practice.bytecode.instrument.agent;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;
import java.util.HashMap;

/**
 * Java6之后允许运行时重载类
 *
 *
 * @author zengsl
 * @version V1.0
 * @date 2021/10/22 2:04 下午
 */
public class Attacher {
    public static void main(String[] args) throws AttachNotSupportedException, IOException, AgentLoadException, AgentInitializationException {
        // 传入目标 JVM pid
        VirtualMachine vm = VirtualMachine.attach("22291");
        // dynamic-proxy-agent项目中打出打jar包
        vm.loadAgent("/Users/zengsl/Project/study/base-practice/dynamic-proxy-agent/target/dynamic-proxy-agent-1.0-SNAPSHOT.jar");

    }
}
