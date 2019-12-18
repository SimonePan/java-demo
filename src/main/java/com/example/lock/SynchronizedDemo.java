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
        log.info("--play-start-");
        sleep(100);
        log.info("--play--end--");
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
            log.info("---playSync--start--");
            sleep(100);
            log.info("---playSync--end--");
        }
    }

    /**
     * 类对象
     */
    public void playSyncObject() {
        synchronized (SynchronizedDemo.class) {
            log.info("---playSyncObject--start--");
            sleep(100);
            log.info("---playSyncObject--end--");
        }
    }

    /**
     * 类属性
     */
    public void playSyncOther() {
        synchronized (lock) {
            log.info("---playSyncOther--start--");
            sleep(100);
            log.info("---playSyncOther--end--");
        }
    }

    public void playSyncOther2() {
        synchronized (lock) {
            log.info("---playSyncOther2--start--");
            sleep(100);
            log.info("---playSyncOther2--end--");
        }
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 1, TimeUnit.MINUTES,
                new DelayQueue());
        threadPoolExecutor.execute(()->{
            demo.playSyncObject();
        });
        threadPoolExecutor.execute(()->{
            SynchronizedDemo.staticPlay();
        });
        threadPoolExecutor.execute(()->{
            demo.play();
        });
    }

}
