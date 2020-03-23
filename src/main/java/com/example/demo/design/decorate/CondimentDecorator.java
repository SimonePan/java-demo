package com.example.demo.design.decorate;

/**
 * 继承Beverage目的：使装饰者能取代Beverage，并非为了继承"行为"，而是为了类型匹配
 *
 * @description: 配料装饰类
 * @author: Grace.Pan
 * @create: 2020-03-16 20:46
 */
public abstract class CondimentDecorator extends Beverage {

    @Override
    public abstract String getDescription();
}
