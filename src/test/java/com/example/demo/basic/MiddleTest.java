package com.example.demo.basic;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Grace.Pan
 * @date 2019/6/17
 */
public class MiddleTest {

    /**
     * static 属于类，可修饰类成员变量，类方法。
     */
    static int i;
    static Integer integer;

    @Test
    public void testStaticVariable() {
        /**
         * int 初始值为0；对象（Integer）初始值为null；
         */
        Assert.assertEquals(0, i);
        Assert.assertNull(integer);
    }

    @Test
    public void test() {
        Assert.assertEquals(4, 9 / 2);
    }

    @Test
    public void testObject() {
        Basic basic = new Basic("nick");
        Basic newBasic = basic;

        basic.setNick("nick1");
        Assert.assertEquals(basic.getNick(), newBasic.getNick());

        newBasic.setNick("newNick");
        Assert.assertEquals(basic.getNick(), newBasic.getNick());

        final Basic f = basic;
        f.setNick("finalNick");
        Assert.assertEquals(f.getNick(), newBasic.getNick());
    }
}
