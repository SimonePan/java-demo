package com.example.demo.design.observable;

import java.util.Observable;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2020-03-16 14:35
 */
public class BSubject extends Observable {
    private Object displayData;

    public void dataChanged() {
        setChanged();
        displayData = "new data";
        notifyObservers(displayData);
    }
}
