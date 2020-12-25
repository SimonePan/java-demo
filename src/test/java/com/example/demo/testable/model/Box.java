package com.example.demo.testable.model;

abstract public class Box {

    protected String data;

    abstract public void put(String something);

    public String get() {
        return data;
    }

}
