package com.example.demo.thread.unsafe;

import java.util.Vector;

/**
 * @description: 双重校验延迟初始化
 * @author: Grace.Pan
 * @create: 2019-12-18 19:46
 */
public class DoubleCheckedLazyInition {
    private static Sequence sequence;

    public static Sequence getSequence() {
        if (sequence == null) {
            synchronized (DoubleCheckedLazyInition.class) {
                if (sequence == null) {
                    sequence = new Sequence(2);
                }
            }
        }
        return sequence;
    }

    /**
     * 不存在则添加
     */
    public void addIfAbsent(Long e) {
        Vector<Long> vector = new Vector<>();
        if (!vector.contains(e)) {
            vector.add(e);
        }
    }
}
