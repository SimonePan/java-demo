package com.example.demo.design.strategy;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: 飞鱼
 * @author: Grace.Pan
 * @create: 2020-03-11 14:54
 */
@Data
@Slf4j
public class FlyingFish extends Fish {

    public void fly() {
        log.info("{} is flying...", super.getName());
    }
}
