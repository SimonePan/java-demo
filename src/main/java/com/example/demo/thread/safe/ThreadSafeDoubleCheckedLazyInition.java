package com.example.demo.thread.safe;

import com.example.demo.thread.unsafe.Sequence;

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
}
