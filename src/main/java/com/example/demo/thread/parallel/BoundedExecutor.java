package com.example.demo.thread.parallel;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * @Author: 一十
 * @Date: 2019-11-27
 * @Version 1.0
 */
public class BoundedExecutor {
    private final ThreadPoolManager exec;
    private final Semaphore semaphore;

    public BoundedExecutor(ThreadPoolManager exec, int bound) {
        this.exec = exec;
        this.semaphore = new Semaphore(bound);
    }

    public void submitTask(final Runnable command)
            throws InterruptedException, RejectedExecutionException {
        semaphore.acquire();
        try {
            exec.execute(() -> {
                try {
                    command.run();
                } finally {
                    semaphore.release();
                }
            });
        } catch (RejectedExecutionException e) {
            semaphore.release();
            throw e;
        }
    }
}
