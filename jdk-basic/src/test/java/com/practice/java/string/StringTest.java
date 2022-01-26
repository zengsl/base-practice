package com.practice.java.string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author zengsl
 * @version V1.0
 * @date 2022/1/11 9:17 AM
 */
public class StringTest {

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        String s = "Hello World";
        System.out.println("s = " + s);
        Field value = String.class.getDeclaredField("value");
        value.setAccessible(true);
        byte[] charArray = (byte[]) value.get(s);
        charArray[5] = '_';
        System.out.println("s = " + s);

    }

    /**
     * 通过程序证明JAVA的char内部编码为UTF-16，而与Charset.defaultCharset()无关。
     * https://www.iteye.com/blog/orange5458-1831368
     */
    @Test
    public void test2() throws UnsupportedEncodingException {
        String str = "I AM 中国人";
        System.out.println(Charset.defaultCharset());
        byte[] utf16 = str.getBytes(StandardCharsets.UTF_16);
        System.out.println(Arrays.toString(utf16));
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            byte high = (byte)(str.charAt(i) >>> 8);
            byte low = (byte) str.charAt(i);
            System.out.println(byteToBinary(high) + byteToBinary(low));
            // UTF16 两字节一编码 ， 开头的编码标记为两字，所以要偏移2个单位来计算数组索引
            System.out.println(byteToBinary(utf16[2+2*i]) + byteToBinary(utf16[2+2*i+1]));
            System.out.println((byteToBinary(high) + byteToBinary(low)).equals(byteToBinary(utf16[2+2*i]) + byteToBinary(utf16[2+2*i+1])));
        }
    }

    /**
     * 将byte转换为对应的二进制字符串
     * @param src 要转换成二进制字符串的byte值
     * @return
     */
    public static String byteToBinary(byte src) {
        System.out.println("BinaryString :" + Integer.toBinaryString(src));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            result.append(src % 2 == 0 ? '0' : '1');
            src = (byte) (src >>> 1);
        }
        return result.reverse().toString();
    }
}
