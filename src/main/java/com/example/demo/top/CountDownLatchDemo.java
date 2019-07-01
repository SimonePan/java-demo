package com.example.demo.top;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Grace.Pan
 * @date 2019/6/30
 */
@Slf4j
public class CountDownLatchDemo {

    @AllArgsConstructor
    public static class Woker {
        CountDownLatch worker;
        CountDownLatch arrived;

        public int num;

        public void play() {
            try {
                arrived.await();
            } catch (InterruptedException e) {
                log.error("---error---");
            }
            log.info("---worker[{}] is working----",num);
            worker.countDown();
        }
    }

    /**
     * worker需要等car到达后开始工作，
     * car需要等10个worker工作结束后，才能启动。
     */
    public static void drive() throws InterruptedException {
        //10个worker
        CountDownLatch worker = new CountDownLatch(10);
        CountDownLatch arrived = new CountDownLatch(1);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 1, TimeUnit.MINUTES,
                new DelayQueue());
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threadPoolExecutor.execute(() -> {
                new Woker(worker, arrived, finalI).play();
            });
        }

        log.info("-----等车中----");
        Thread.sleep(100);
        log.info("-----车到啦----");
        arrived.countDown();
        log.info("-----等待装货----");
        worker.await();
        //arrived.await();
        log.info("-----装货结束，车重新出发----");
    }

    public static void main(String[] args) {
        try {
            CountDownLatchDemo.drive();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
