package com.example.demo.testable.mock;

/**
 * @author flin
 */
public class DemoPrivateAccess {

    /**
     * a private static field
     */
    private static int staticCount = 2;
    /**
     * a private member field
     */
    private int count  = 1;
    /**
     * a constant field
     */
    public final Double pi = 3.14;

    /**
     * private static method
     */
    private static String privateStaticFunc(String s, int i) {
        return s + " + " + i;
    }

    /**
     * private member method
     */
    private String privateFunc(String s, int i) {
        return s + " - " + i;
    }

}
