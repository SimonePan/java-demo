package com.example.demo.thread.safe;

import com.example.demo.thread.unsafe.Sequence;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 通过封装使线程安全
 * @author: Grace.Pan
 * @create: 2020-01-07 20:04
 */
public class SafePackageSet {
    /**
     * Sequence并非线程安全，HashSet也并非线程安全，但由他俩组合的类SafePackageSet是线程安全的。
     * 1. private修饰，保证sequenceSet不会逸出。
     * 2. 状态sequenceSet所有访问方式都加了内置锁。
     */
    private final Set<Sequence> sequenceSet = new HashSet<>();

    public synchronized void addSequence(Sequence e) {
        sequenceSet.add(e);
    }

    public synchronized boolean containsSequence(Sequence e) {
        return sequenceSet.contains(e);
    }
}
