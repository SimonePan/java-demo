package com.example.demo.design.strategy;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: 锦鲤
 * @author: Grace.Pan
 * @create: 2020-03-11 14:51
 */
@Data
@Slf4j
public class Koi extends Fish {

    public void bless() {
        log.info("{}: Good Lucky for you.", super.getName());
    }
}
