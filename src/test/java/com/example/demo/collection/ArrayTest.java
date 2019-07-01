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
    public void testSearchUnsorted() {
        //查找第一个>=5的index
        int[] old = {1, 4, 2, 6, 5, 8, 0, 9};
        for (int i = 0; i < old.length; i++) {
            if (old[i] >= 5) {
                Assert.assertEquals(3, i);
                break;
            }
        }
    }

    @Test
    public void testSearchSorted() {
        //查找第一个>=key的index
        int[] old = {3, 4, 6, 9, 22, 45, 66, 78, 99, 101, 102, 103, 104, 105, 109, 110, 111, 113, 114, 115};
        int key = 46;

        int low = 0;
        int high = old.length - 1;
        int r = -1;
        int count = 0;
        while (low <= high) {
            count++;
            int mid = (low + high) >>> 1;
            int midVal = old[mid];
            if (mid == 0) {
                if (midVal >= key) {
                    r = mid;
                }
                break;
            }
            if (midVal < key) {
                low = mid + 1;
            } else if (old[mid - 1] > key) {
                high = mid - 1;
            } else if (midVal >= key) {
                r = mid;
                break;
            }
        }
        if (r==-1){
            System.out.println("--no--");
        }else {
            System.out.println("old[" + r + "]=" + old[r]);
        }
        System.out.println("count=" + count);
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
