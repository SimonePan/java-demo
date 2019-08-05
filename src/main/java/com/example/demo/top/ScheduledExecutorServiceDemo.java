package com.example.demo.top;

import java.util.concurrent.*;

/**
 * @author Grace.Pan
 * @date 2019/7/3
 */
public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);
        executor.scheduleAtFixedRate(()->System.out.println("run:"+System.currentTimeMillis()),10,100,TimeUnit
                .MILLISECONDS);

        //executor.scheduleWithFixedDelay(()->System.out.println("run:"+System.currentTimeMillis()),0,10,TimeUnit
                //.SECONDS);
    }
}
