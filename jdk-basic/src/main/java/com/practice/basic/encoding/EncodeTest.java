package com.practice.basic.encoding;

import java.nio.charset.StandardCharsets;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/12/15 10:03 上午
 */
public class EncodeTest {
    public static void main(String[] args) {
        byte[] bytes = "Hello啊".getBytes(StandardCharsets.UTF_8);
        for (byte aByte : bytes) {
            // 啊的UTF-8编码是三字节编码，开头为111
            System.out.println(Integer.toBinaryString(aByte & 0XFF));
        }
    }
}
