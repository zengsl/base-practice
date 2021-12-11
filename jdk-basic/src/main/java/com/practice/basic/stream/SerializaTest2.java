package com.practice.basic.stream;

import java.io.*;

/**
 * 序列化所有的属性，包括transient
 *
 * @author zengsl
 * @version V1.0
 * @date 2021/11/13 8:44 下午
 */
public class SerializaTest2 implements Externalizable {

    public int x = 1;

    transient public int y = 2;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "/Users/zengsl/Project/study/base-practice/jdk-basic/src/main/java/com/practice/basic/stream/SerializaTestFile2.txt";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(new SerializaTest2());
        objectOutputStream.close();


        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        SerializaTest2 o = (SerializaTest2) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(o.x);
        System.out.println(o.y);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("readExternal");
    }
}
