package com.practice.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author zengsl
 * @version V1.0
 * @date 2022/1/11 4:47 PM
 */
public class IoTest {

   /* @Test
    public void test() {

    }*/

    public static void main(String[] args) {
        char[] cbuf = new char[2];
        cbuf[0] = '一';
        System.out.println(Integer.toString(cbuf[0]));
        cbuf[1] = 'A';
        System.out.println(Integer.toString(cbuf[1]));

        byte[] b = "一".getBytes(StandardCharsets.UTF_8);
        for (byte b1 : b) {
            System.out.println(Integer.toHexString(b1));
        }
    }

    private byte[] getClassBytes(File file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);
        while (true) {
            int i = fc.read(by);
            if (i == 0 || i == -1) {
                break;
            }
            by.flip();
            wbc.write(by);
            by.clear();
        }
        fis.close();
        return baos.toByteArray();
    }
}
