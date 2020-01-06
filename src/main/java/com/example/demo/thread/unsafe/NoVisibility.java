package com.example.demo.thread.unsafe;

import lombok.extern.slf4j.Slf4j;

/**
 * @description: 在没有同步的情况下共享变量（X）
 * @author: Grace.Pan
 * @create: 2019-12-18 20:08
 */
@Slf4j
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                // 释放CPU，不释放锁，允许优先级相同或更高的线程抢占资源。也可能自己再次获得CPU。
                Thread.yield();
            }
            log.info("number=" + number);
        }
    }

    /**
     * 当主线程写入number,然后在没有同步情况下写入read，那么读线程看到的顺序可能与写入的顺序完全相反。
     *
     * @param args
     */
    public static void main(String[] args) {
        new ReaderThread().start();
        number = 24;
        ready = true;
    }
}
