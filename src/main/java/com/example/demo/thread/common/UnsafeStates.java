package com.example.demo.thread.common;

import java.util.Set;

/**
 * @description: 使内部的可变状态逸出
 * @author: Grace.Pan
 * @create: 2020-01-02 14:06
 */
public class UnsafeStates {
    private static Set<Long> secret;

    /**
     * 在某个非私有的方法返回该引用：任何调用者都可以修改这个Set的内容。
     */
    public Set<Long> getSecrets() {
        return secret;
    }
}
