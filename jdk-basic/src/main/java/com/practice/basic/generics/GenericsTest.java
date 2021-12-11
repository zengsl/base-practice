package com.practice.basic.generics;

import com.practice.basic.generics.model.Apple;
import com.practice.basic.generics.model.Fruit;
import com.practice.basic.generics.model.RedApple;

import java.util.ArrayList;
import java.util.List;

/**
 * PECS
 *
 * @author zengsl
 * @version V1.0
 * @date 2021/11/17 4:08 下午
 */
public class GenericsTest {

    public static void main(String[] args) {
        //List< ? extends Integer> testList = new ArrayList<>();
        //testList.add(new Integer(12));

        ArrayList<Apple> appleList2 = new ArrayList<>();
        appleList2.add(new Apple());
        List<? extends Fruit> testList = appleList2;
        //testList.add(new Apple());// 编译报错
        Fruit fruit = testList.get(0);


        ArrayList<Apple> appleList = new ArrayList<>();
        List<? super Apple> testList2 = appleList;
        testList2.add(new Apple());
        testList2.add(new RedApple());
        //testList2.add(new Fruit()); // 编译报错
        //testList2.add(new Food()); // 编译报错
        Object object = testList2.get(0);

    }
}
