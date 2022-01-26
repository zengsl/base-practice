package com.practice.java.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author zengsl
 * @version V1.0
 * @date 2022/1/11 10:01 AM
 */
public class IteratorTest {

    @Test
    public void test() {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("1");
        objects.add("2");
        objects.add("4");
        Iterator<String> iterator = objects.iterator();
        while (iterator.hasNext()) {
            System.out.println("loop1 : " + iterator.next());
        }
        while (iterator.hasNext()) {
            System.out.println("loop2 : " + iterator.next());
        }
    }
}
