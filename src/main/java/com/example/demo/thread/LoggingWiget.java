package com.example.demo.thread;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2019-12-31 11:06
 */
public class LoggingWiget {

    public synchronized void doSomething() {
        System.out.println("LoggingWiget");
        printLog();
    }

    public synchronized void printLog() {
        System.out.println("printLog");
    }
}
