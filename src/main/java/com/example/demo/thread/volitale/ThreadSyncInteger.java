package com.example.demo.thread.volitale;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2020-09-21 16:21
 */
public class ThreadSyncInteger {
    private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized void set(int value) {
        this.value = value;
    }
}
