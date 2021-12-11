package com.practice.sync;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/11/29 3:48 下午
 */
public class SyncTest {

    public volatile int size = 1;

    public static void main(String[] args) {
        SyncTest syncTest = new SyncTest();
        for (int i = 0; i < 10; i++) {
            new Thread(new Counter(syncTest)).start();
        }
    }

    private static class Counter implements Runnable {
        public Counter(SyncTest syncTest) {
            this.syncTest = syncTest;
        }

        private final SyncTest syncTest;

        @Override
        public void run() {
            synchronized (this.syncTest) {
                this.syncTest.size++;
            }
        }
    }
}



