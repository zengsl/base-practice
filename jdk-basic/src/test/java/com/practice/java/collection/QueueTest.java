package com.practice.java.collection;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author zengsl
 * @version V1.0
 * @date 2022/1/11 10:31 AM
 */
public class QueueTest {

    @Test
    public void test() {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("string");// add
        queue.offer("string2");// add
        System.out.println(queue.poll());
        System.out.println(queue.remove());
        System.out.println(queue.size());
        Queue<String> queue2 = new ArrayBlockingQueue<>(2);
        queue2.offer("3");
        queue2.offer("4");
        System.out.println(queue2.size());


    }
}
