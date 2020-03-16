package com.example.demo.design.observable;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2020-03-16 14:23
 */
@Slf4j
public class AObserver implements Observer, Display {
    private Object displayData;

    @Override
    public void update(Subject subject, Object args) {
        displayData = args;
        display();
    }

    @Override
    public void display() {
        log.info(displayData.toString());
    }
}
