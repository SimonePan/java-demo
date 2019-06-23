package com.example.demo.medium;

/**
 * @author Grace.Pan
 * @date 2019/6/19
 */
public class Medium {
    public static void main(String args[]) {

        float[][] f1 = {{1.2f,2.3f},{4.5f,5.6f}};
        Object oo = f1;
        // Compiler error f1[1]=oo;

    }

    private void methodA(String[] args){

    }
}
