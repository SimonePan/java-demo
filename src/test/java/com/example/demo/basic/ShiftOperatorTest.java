package com.example.demo.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Grace.Pan
 * @date 2019/6/26
 */
@Slf4j
public class ShiftOperatorTest {

    @Test
    public void test() {
        log.info(getInt(2));
        log.info(getInt(3));
        log.info(getInt(4));
        log.info(getInt(5));
        log.info(getInt(6));
        log.info(getInt(7));
        log.info(getInt(8));
        log.info(getInt(9));
        log.info(getInt(10));
        log.info(getInt(11));
        log.info(getInt(12));
        log.info(getInt(13));
        log.info(getInt(14));
    }

    @Test
    public void test2() {
        // >>, <<, >>> 在Java中都是无符号
        log.info((33 >> 1) + "");
        log.info((33 >> 2) + "");
        log.info((33 >> 3) + "");
        log.info((33 >> 4) + "");
        log.info((33 >> 5) + "");
        log.info((33 >> 6) + "");
    }

    @Test
    public void test1() {
        int n = 33;
        n |= n >>> 1;
        log.info(n + "");
        n |= n >>> 2;
        log.info(n + "");
        n |= n >>> 4;
        log.info(n + "");
        n |= n >>> 8;
        log.info(n + "");
        n |= n >>> 16;
        log.info(n + "");
    }

    @Test
    public void test3() {
        log.info((33 << 1) + "");
        log.info((33 << 2) + "");
        log.info((33 << 3) + "");
        log.info((33 << 4) + "");
        log.info((33 << 5) + "");
        log.info((33 << 6) + "");
    }

    private String getInt(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + "";
    }
}
