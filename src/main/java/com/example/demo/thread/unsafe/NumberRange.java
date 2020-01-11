package com.example.demo.thread.unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 对象的组合
 * @author: Grace.Pan
 * @create: 2020-01-10 14:29
 */
public class NumberRange {
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);
    private final AtomicInteger number = new AtomicInteger(0);
    /**
     * 线程不安全
     *
     * @param i
     */
    public void setLower(int i) {
        if (i > upper.get()) {
            throw new IllegalArgumentException("最小值不能大于最大值");
        }
        lower.set(i);
    }

    /**
     * 线程安全
     * @param i
     */
    public void setNumber(int i){
        number.set(i);
    }

    /**
     * 线程不安全
     *
     * @param i
     */
    public void setUpper(int i) {
        if (i < lower.get()) {
            throw new IllegalArgumentException("最大值不能小于最小值");
        }
        upper.set(i);
    }
}
