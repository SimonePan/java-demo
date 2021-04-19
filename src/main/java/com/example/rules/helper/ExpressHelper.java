package com.example.rules.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2021-03-18 10:29
 */
@Service
@Slf4j
public class ExpressHelper {

    /**
     * 向上取整
     *
     * @param a
     * @return
     */
    public Long upRode(BigDecimal a) {
        return a.setScale(0, RoundingMode.UP).longValue();
    }

    /**
     * 存在
     *
     * @param a
     * @return
     */
    public boolean exist(BigDecimal a) {
        return a != null;
    }

}
