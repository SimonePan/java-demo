package com.example.demo.basic;

import com.alibaba.fastjson.JSON;
import com.example.demo.enums.Season;
import org.junit.Test;

/**
 * @author Grace.Pan
 * @date 2019/6/23
 */
public class EnumTest {

    @Test
    public void testEnumSeriza() {
        Basic basic = new Basic("nick");
        basic.setSeason(Season.AUTUMN);
        String s = JSON.toJSONString(basic);
        Basic basic1 = JSON.parseObject(s, Basic.class);
    }

}
