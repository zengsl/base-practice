package com.practice.aio.example;

import lombok.SneakyThrows;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.TimeUnit;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/11/12 3:53 下午
 */
public class DemoAIOServer {

    public static void main(String[] args) throws Exception {
        final AsynchronousServerSocketChannel serverSocketChannel =
                AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(5001));

        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            @Override
            public void completed( AsynchronousSocketChannel ch, Void att) {

                try {
                    System.out.println("接受了一个连接：" + ch.getRemoteAddress()
                            .toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // accept the next connection
                serverSocketChannel.accept(null, this);

                // handle this connection
                //handle(ch);
            }

            @Override
            public void failed(Throwable exc, Void att) {
                System.out.println("出错了：" + exc.getMessage());
            }
        });


        TimeUnit.MINUTES.sleep(Integer.MAX_VALUE);
    }
}
