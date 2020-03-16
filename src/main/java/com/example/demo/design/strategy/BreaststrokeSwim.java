package com.example.demo.design.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * @description: 蛙泳
 * @author: Grace.Pan
 * @create: 2020-03-13 13:41
 */
@Slf4j
public class BreaststrokeSwim implements SwimBehavior {
    @Override
    public void swim() {
        log.info("breaststroke swim");
    }
}
