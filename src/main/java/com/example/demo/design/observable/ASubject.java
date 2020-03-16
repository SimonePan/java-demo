package com.example.demo.design.observable;

import java.util.ArrayList;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2020-03-16 14:25
 */
public class ASubject implements Subject {

    private Boolean changed;
    private ArrayList<Observer> obs;
    private Object displayData;

    public ASubject() {
        obs = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        obs.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int index = obs.indexOf(o);
        if (index > 0) {
            obs.add(o);
        }

    }

    @Override
    public void notifyObservers() {
        for (Observer o : obs) {
            o.update(this, displayData);
        }
        clearChanged();
    }

    @Override
    public void setChanged() {
        changed = true;
    }

    @Override
    public void clearChanged() {
        changed = false;
    }

    public void dataChanged() {
        setChanged();
        notifyObservers();
    }

}
