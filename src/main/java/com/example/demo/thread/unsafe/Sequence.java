package com.example.demo.thread.unsafe;

import java.util.ArrayList;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2019-12-18 19:41
 */
public class Sequence {
    private volatile int value;

    public Sequence(int value) {
        this.value = value;
    }

    public int getNext() {
        return value++;
    }
}
