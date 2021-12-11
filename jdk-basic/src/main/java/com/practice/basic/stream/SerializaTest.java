package com.practice.basic.stream;

import java.io.*;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/11/13 8:44 下午
 */
public class SerializaTest implements Serializable {

    public int x = 1;

    transient public int y = 2;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "/Users/zengsl/Project/study/base-practice/jdk-basic/src/main/java/com/practice/basic/stream/SerializaTestFile.txt";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(new SerializaTest());
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        SerializaTest o = (SerializaTest) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(o.x);
        System.out.println(o.y);
    }
}
