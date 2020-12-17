package com.example.demo.thread.volitale;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2020-09-21 16:21
 */
public class ThreadVolatileInteger {
    private volatile int value;

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}
