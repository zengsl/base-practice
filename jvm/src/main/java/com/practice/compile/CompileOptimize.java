package com.practice.compile;

/**
 * 后端编译优化观察，使用Ideal Graph Visualizer观察
 * JDK需要是FastDebug或SlowDebug优化级别的HotSpot虚拟机
 * <p>
 * https://docs.oracle.com/en/graalvm/enterprise/20/docs/tools/igv/#:~:text=Ideal%20Graph%20Visualizer%20Ideal%20Graph%20Visualizer%20%28IGV%29%20is,building%20on%20top%20of%20Oracle%20GraalVM%20Enterprise%20Edition.
 *
 * @author zengsl
 * @version V1.0
 * @date 2021/12/6 10:39 上午
 */
public class CompileOptimize {

    public static final int NUM = 15000;

    public static int doubleValue(int i) {
        // 这个空循环用于后面演示JIT代码优化过程
        for (int j = 0; j < 100000; j++) ;
        return i * 2;
    }

    public static long calcSum() {
        long sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += doubleValue(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            calcSum();
        }
    }

}
