package com.example.demo.design.observable;

import java.util.ArrayList;

/**
 * @description: 主题
 * @author: Grace.Pan
 * @create: 2020-03-16 14:11
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
    void setChanged();

    void clearChanged();
    
}
