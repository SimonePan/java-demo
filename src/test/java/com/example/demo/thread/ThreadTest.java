package com.example.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2020-12-17 15:00
 */
public class ThreadTest {

    // 继承Thread重写run()方法
   public static class PrimeThread extends Thread {
        public void run() {
            // 业务逻辑
            System.out.println(Thread.currentThread().getName()+" PrimeThread#run()执行成功");
        }
    }

    // 实现Runnable重写run()方法
    public static class RunnableTask implements Runnable{
        @Override
        public void run() {
            // 业务逻辑
            System.out.println(Thread.currentThread().getName()+" RunnableTask#run()执行成功");
        }
    }

    // 实现Runnable重写run()方法
    public static class CallableTask implements Callable<String> {
        @Override
        public String call() {
            // 业务逻辑
            return Thread.currentThread().getName()+" CallableTask#run()执行成功";
        }
    }

    public static void main(String[] args) {
        CallableTask callableTask = new CallableTask();
        FutureTask<String> futureTask = new FutureTask<>(callableTask);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        /*RunnableTask runnableTask = new RunnableTask();
        new Thread(runnableTask).start(); // 启动线程
        new Thread(runnableTask).start(); // 启动线程
        PrimeThread thread = new PrimeThread();
        thread.start(); // 启动线程*/
    }
}
