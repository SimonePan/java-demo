package com.example.demo.thread.safe;

import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @date 6/23/15.
 */
@Service
public class ThreadPoolManager {
    private final int corePoolSize = 4;
    private final int maximumPoolSize = 8;
    private final int keepAliveTime = 10;
    private final int capacity = 500;

    private ThreadPoolExecutor threadPoolExecutor;

    public ThreadPoolManager() {
        threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(capacity));
    }

    /**
     * 执行
     *
     * @param runnable 待执行线程
     */
    public void execute(Runnable runnable) {
        threadPoolExecutor.execute(runnable);
    }
}
