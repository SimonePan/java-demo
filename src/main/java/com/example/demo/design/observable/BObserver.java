package com.example.demo.design.observable;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2020-03-16 15:09
 */
@Slf4j
public class BObserver implements Observer, Display {
    private Object displayData;

    @Override
    public void update(Observable o, Object arg) {
        displayData = arg;
        display();
    }

    @Override
    public void display() {
        log.info(displayData.toString());
    }
}
