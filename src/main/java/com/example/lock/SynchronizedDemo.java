package com.example.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Grace.Pan
 * @date 2019/7/1
 */
@Slf4j
public class SynchronizedDemo {

    String lock = "lock";

    /**
     * 实例方法
     */
    public synchronized void play() {
        log.info("--play--");
    }

    /**
     * 静态/类方法
     */
    public static synchronized void staticPlay() {
        log.info("--staticPlay--");
    }

    /**
     * 实例对象
     */
    public void playSync() {
        synchronized (this) {
            log.info("---playSync---");
        }
    }

    /**
     * 类对象
     */
    public void playSyncObject() {
        synchronized (SynchronizedDemo.class) {
            log.info("---playSyncObject---");
        }
    }

    /**
     * 类对象
     */
    public void playSyncOther() {
        synchronized (lock) {
            log.info("---playSyncOther---");
            sleep(100);
        }
    }

    public void playSyncOther2() {
        synchronized (lock) {
            log.info("---playSyncOther2---");
            sleep(100);
        }
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
            log.info("---wake up---");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 1, TimeUnit.MINUTES,
                new DelayQueue());
        //threadPoolExecutor.execute(demo.playSyncOther());
    }

}
