package com.practice.basic.bytecode.init;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/11/16 4:41 下午
 */
public class Parent {

//    public static int A = 1;
    public final static int A = 1; // ConstClass类的常量，但其实在编译阶段通过常量传播优化，已经将此常量的值“hello world”直接存储在NotInitialization类的常量池中，以后NotInitialization对常量 ConstClass.HELLOWORLD的引用，实际都被转化为NotInitialization类对自身常量池的引用了。也就是 说，实际上NotInitialization的Class文件之中并没有ConstClass类的符号引用入口，这两个类在编译成 Class文件后就已不存在任何联系了。

    static {
        //A = 2;
        System.out.println("init Parent A=" + A);
    }

}

class Sub extends Parent {
    public static int B = A;

    static {
        System.out.println("init Sub");
    }


}

class Demo {
    public static void main(String[] args) {
        System.out.println(Sub.A);
    }
}