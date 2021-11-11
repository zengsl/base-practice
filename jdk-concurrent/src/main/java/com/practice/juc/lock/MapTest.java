package com.practice.juc.lock;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/10/25 4:59 下午
 */
public class MapTest {

    public static void main(String[] args) {
        Map tMap = new Hashtable();
        tMap.put("name", "zengsl");
        Map cMap = new ConcurrentHashMap();
        cMap.put("name", "zengsl");
        cMap.get("name");
    }
}
