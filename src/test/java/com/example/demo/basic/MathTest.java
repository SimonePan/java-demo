package com.example.demo.basic;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Grace.Pan
 * @date 2019/6/19
 */
public class MathTest {

    @Test
    public void testRound() {
        Assert.assertEquals(12, Math.round(12.44f));
        Assert.assertEquals(13, Math.round(12.64f));
        Assert.assertEquals(-12, Math.round(-12.44f));
        Assert.assertEquals(-13, Math.round(-12.64f));
        Assert.assertEquals(13, Math.round(12.5f));
        Assert.assertEquals(-12, Math.round(-12.5f));
    }

    @Test
    public void testOptional() {
        List<Basic> basics = Arrays.asList(new Basic("a"), new Basic("b"), new Basic("c"));
        Basic basic = basics.get(0);
        //normal method
        if (basic != null) {
            System.out.println(basic.nick);
        }
        // more elegant
        Optional<Basic> s1 = Optional.ofNullable(basic);
        s1.ifPresent(System.out::println);
        s1.orElse(new Basic("d"));

        String param = "param";
        s1.orElseGet(() -> getString(param));

        //夺命连环null检查
        String s = s1.map(basic1 -> basic1.nick).map(str -> str.toLowerCase()).orElse(null);
        //结果同上
        String s2;
        if (basic != null) {
            String nick = basic.nick;
            if (nick != null) {
                s2 = nick.toLowerCase();
            } else {
                s2 = null;
            }
        } else {
            s2 = null;
        }

    }

    private Basic getString(String param) {
        return new Basic(param);
    }

}
