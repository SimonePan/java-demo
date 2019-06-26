package com.example.demo.collection;

import com.example.demo.basic.Basic;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Grace.Pan
 * @date 2019/6/23
 */
public class ArrayTest {

    @Test
    public void testRefer() {
        String[] old = {"a", "b", "c"};
        String[] newStrings = old;
        old[0] = "a1";
        Assert.assertEquals(old[0], newStrings[0]);
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
