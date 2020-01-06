package com.example.demo.thread.common;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 发布与逸出
 * @author: Grace.Pan
 * @create: 2020-01-02 14:02
 */
public class Publish {
    private Long userId;

    public Long getUserId(){
        return userId;
    }

    /**
     * 将对象的引用(secret)保存到公有的静态变量，以便任何类和线程都能看见这个对象
     */
    public static Set<Long> secret;

    public void init() {
        secret = new HashSet<>();
    }

    public void add(Long e) {
        secret.add(e);
    }

}
