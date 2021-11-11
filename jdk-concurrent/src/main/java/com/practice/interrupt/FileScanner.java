package com.practice.interrupt;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * https://www.infoq.cn/article/java-interrupt-mechanism
 * 中断机制：是java提供的一种线程之间的协作机制。执行中断不一定就会中断线程，只是修改中断标识，由线程自行决定处理（抛出中断异常交给上层调用处理）
 * 如果线程是阻塞状态被中断会抛出InterruptedException，结束阻塞状态。
 *
 * @author zengsl
 * @version V1.0
 * @date 2021/10/23 7:57 下午
 */
public class FileScanner {
    private static void listFile(File f) throws InterruptedException {
        if (f == null) {
            throw new IllegalArgumentException();
        }
        if (f.isFile()) {
            System.out.println(f);
            return;
        }
        File[] allFiles = f.listFiles();
        if (Thread.interrupted()) {
            throw new InterruptedException(" 文件扫描任务被中断 ");
        }
        for (File file : allFiles) {
            // 还可以将中断检测放到这里
            listFile(file);
        }
    }

    public static String readFromConsole() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) throws Exception {
        final Thread fileIteratorThread = new Thread() {
            @Override
            public void run() {
                try {
                    listFile(new File("/Project"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    if ("quit".equalsIgnoreCase(readFromConsole())) {
                        if (fileIteratorThread.isAlive()) {
                            fileIteratorThread.interrupt();
                            return;
                        }
                    } else {
                        System.out.println(" 输入 quit 退出文件扫描 ");
                    }
                }
            }
        }.start();
        fileIteratorThread.start();
    }
}
