package com.example.demo.basic;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Grace.Pan
 * @date 2019/6/17
 */
public class BasicTest {


    @Test
    public void testForeach_whenBreak() {
        int sum = 0;
        for (int x = 0; x < 10; x++) {
            sum += x;
            if (x % 3 == 0) {
                break;
            }
        }
        Assert.assertEquals(0, sum);
    }

    @Test
    public void testForeach_whenContinue() {
        int sum = 0;
        for (int x = 0; x < 10; x++) {
            sum += x;
            if (x % 3 == 0) {
                continue;
            }
        }
        Assert.assertEquals(45, sum);
    }

    @Test
    public void testAdd() {
        int sum = 0;
        sum += 2;
        Assert.assertEquals(2, sum);
        sum++;
        Assert.assertEquals(3, sum);
    }

    @Test
    public void testInt() {
        int sum = Integer.MAX_VALUE;
        sum += 2;
        System.out.println(sum);
    }

    @Test
    public void testIntAndLong() {
        long sum = 100;
        System.out.println(sum);
    }

    @Test
    public void testInt2() {
        int sum = Integer.MAX_VALUE;
        sum += 2L;
        System.out.println(sum);
    }

    @Test
    public void testIntAddLong() {
        long i = 2;
        int sum = 2147483647;
        System.out.println(sum + i);
    }

    @Test
    public void testFlag() {
        boolean flag = 10 % 2 == 1 && 10 / 3 == 0 && 1 / 0 == 0;
        System.out.println(flag ? 'x' : 'y');
    }

    @Test
    public void testInc() {
        int x = 10;
        double y = 20.2;
        long z = 10L;
        String a = "" + x + y * z;
        Assert.assertEquals("10202.0", a);

    }

    @Test
    public void testWhile() {
        int num = 0;
        int x = 10;
        while (x > 0) {
            num += x;
        }
        System.out.println(num);
    }

    @Test
    public void testChar() {
        int num = 68;
        char c = (char) num;
        System.out.println(c);
    }

    @Test
    public void testLong() {
        int num = 50;
        num = num++ * 2;
        System.out.println(num);
        // java 解释程序
    }

    @Test
    public void testIncease() {
        System.out.println(inc(10) + inc(8) + inc(-10));
    }

    @Test
    public void testString() {
        String z = "";
        for (int i = 0; i < 5; i++) {
            z += i;
        }

        System.out.println(z);
    }

    private int inc(int temp) {
        if (temp > 0) {
            return temp * 2;
        }
        return -1;
    }

    @Test
    public void testAddAdd() {
        int i = 1;
        int j = i++;
        System.out.println("--" + i);
        if (i == (++j) && (i++) == j) {
            i += j;
            System.out.println("true=");
        }
        System.out.println(i);
        float f = 1.2f;
        byte c = 'x';
    }

    @Test
    public void testSwitch() {
        char c = 'A';
        int num = 10;
        switch (c) {
            case 'B':
                num++;
                System.out.println("B");
            case 'A':
                num++;
                System.out.println("A");
            case 'Y':
                num++;
                System.out.println("C");
                break;
            default:
                num--;
                System.out.println("d");
        }
        System.out.println(num);
    }

    @Test
    public void testSwitch2() {
        int num = 10;
        switch (num) {
            default:
                num++;
            case 'B':
                num++;
                break;
            case 'A':
                num++;
            case 'C':
                num++;
        }
        Assert.assertEquals(12, num);
    }

    @Test
    public void testSwitch3() {
        int num = -1;
        switch (num) {
            default:
                num = 0;
            case 2:
                num = 2;
                break;
            case 3:
                num = 3;
            case -1:
                num = 10;
        }
        Assert.assertEquals(10, num);
    }

}