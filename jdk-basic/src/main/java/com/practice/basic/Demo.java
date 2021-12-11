package com.practice.basic;

/**
 * public static void main(java.lang.String[]);
 * descriptor: ([Ljava/lang/String;)V
 * flags: ACC_PUBLIC, ACC_STATIC
 * Code:
 * stack=2, locals=2, args_size=1
 * 0: new           #5                  // class com/practice/basic/Son //创建一个对象，并将其引用值压入栈顶
 * 3: dup //复制栈顶数值并把数值入栈 此时栈顶有两个引用值 。下方调用invokespecial会消耗一个栈顶元素
 * 4: invokespecial #6                  // Method com/practice/basic/Son."<init>":()V   //调用一些需要特殊处理的实例方法，包括实例初始化方法（）、私有方法和父类方法。这三类方法的调用对象在编译时就可以确定。
 * 7: astore_1   // 把栈顶 引用 型数值存入第 2 个局部变量（出栈）
 * 8: aload_1   // 把局部变量第 2 个引用型局部变量压入栈顶（入栈，变量表中还有此值）
 * 9: invokevirtual #7                  // Method sayHello:()V
 * 12: return
 * LineNumberTable:
 * line 15: 0
 * line 16: 8
 * line 17: 12
 * LocalVariableTable:
 * Start  Length  Slot  Name   Signature
 * 0      13     0  args   [Ljava/lang/String;
 * 8       5     1     d   Lcom/practice/basic/Demo;
 *
 * @author zengsl
 * @version V1.0
 * @date 2021/11/14 4:51 下午
 */
public class Demo {
    static {
        System.out.println("");
    }
    private static int staticF = 0;
    private final static int staticF2 = 0;

    public void sayHello() {
        System.out.println("this is Demo");
    }

    public static void main(String[] args) {
        /*Demo d = new Son();
        d.sayHello();*/
    }
}


/*
class Son extends Demo implements Serializable {

    @Override
    public void sayHello() {
        int i = 1;
        int x = 10;
        int x1 = 10;
        int x2 = 10;
        int x3 = 10;
        int x4= 10;
        int x5 = 10;
        int x6 = 10;
        int x7 = 10;
        int x8 = 10;
        int x9 = 10;
        int x10 = 10;
        int x11 = 10;
        int x12 = 10;
        int x13 = 10;
        System.out.println("this is Son");
    }


    public void deep() {
        try {

        } catch (Exception e) {

        }
    }
}*/
