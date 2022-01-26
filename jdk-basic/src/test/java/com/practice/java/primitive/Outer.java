package com.practice.java.primitive;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zengsl
 * @version V1.0
 * @date 2022/1/10 3:35 PM
 */
public class Outer {

    public void outMethod() {

        int a = 10;

        class Inner {
            void innerMethod() {
                System.out.println(a);
            }
        }
        Inner inner = new Inner();
        inner.innerMethod();
    }

    public static void change(Map map) {
        //map = new HashMap();
        map.put(3, 3);
    }
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.outMethod();


        String s1 = "嘻嘻";
        String s2 = "嘻嘻";
        String s3 = new String("嘻嘻");
        System.out.println("s1 == s2:" + (s1 == s2));
        System.out.println("s1 == s3:" + (s1 == s3));
        System.out.println("s1.intern() == s3.intern() :" + (s1.intern() == s3.intern() ));
        System.out.println("\"嘻嘻\" == s3.intern() :" + ("嘻嘻".intern() == s3.intern() ));

        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put(1, 1);
        objectHashMap.put(2, 1);
        change(objectHashMap);
        System.out.println(objectHashMap);
    }
}
