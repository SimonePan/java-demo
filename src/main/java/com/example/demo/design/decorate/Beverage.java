package com.example.demo.design.decorate;

/**
 * @description: 饮料
 * @author: Grace.Pan
 * @create: 2020-03-16 20:44
 */
public abstract class Beverage {
    String description = "Unknown Beverage";
    Integer size = 1;

    public String getDescription() {
        return description;
    }

    public abstract double cost();

    public Integer getSize() {
        return size;
    }
}
