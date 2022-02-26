package com.practice.datastruct.skiplist;

/**
 * @author zengsl
 * @version V1.0
 * @date 2022/2/14 2:00 PM
 */
public class SkipListTest {

    public static void main(String[] args) {

        SkipList<Integer> objectSkipList = new SkipList<>();
        objectSkipList.add(1,1);
        objectSkipList.add(2,3);
        objectSkipList.add(3,4);
        objectSkipList.add(3,8);
        objectSkipList.add(4,5);
        objectSkipList.add(5,6);
        objectSkipList.add(6,7);
        objectSkipList.add(7,8);
        objectSkipList.add(8,9);
        objectSkipList.add(9,10);
        objectSkipList.add(10,12);
        objectSkipList.print();
    }
}
