package com.practice.sync;

import org.openjdk.jol.info.ClassLayout;

import java.lang.management.ManagementFactory;

/**
 * 锁升级
 * 偏向锁和hashcode
 * 参考：https://blog.csdn.net/P19777/article/details/103125545
 *
 * @author zengsl
 * @version V1.0
 * @date 2021/11/29 5:14 下午
 */
public class LockUpgrade {

    public static void main(String[] args) throws Exception {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        // get pid
        String pid = name.split("@")[0];
        System.out.println("Pid is:" + pid);
        // 需要sleep一段时间，因为java对于偏向锁的启动是在启动几秒之后才激活。
        // 因为jvm启动的过程中会有大量的同步块，且这些同步块都有竞争，如果一启动就启动
        // 偏向锁，会出现很多没有必要的锁撤销
        Thread.sleep(5000);
        MonitorObject monitorObject = new MonitorObject();
        // 未出现任何获取锁的时候
        System.out.println(ClassLayout.parseInstance(monitorObject).toPrintable());
        synchronized (monitorObject) {
            // 获取一次锁之后
            System.out.println(ClassLayout.parseInstance(monitorObject).toPrintable());
        }
        // 输出hashcode
        System.out.println(monitorObject.hashCode());
        // 计算了hashcode之后
        System.out.println(ClassLayout.parseInstance(monitorObject).toPrintable());
        synchronized (monitorObject) {
            // 再次获取锁
            System.out.println(ClassLayout.parseInstance(monitorObject).toPrintable());
        }
    }

}

