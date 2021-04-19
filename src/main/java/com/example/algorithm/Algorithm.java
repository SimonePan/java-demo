package com.example.algorithm;

import java.util.Scanner;

/**
 * @description: 基础算法
 * @author: Grace.Pan
 * @create: 2021-04-19 16:30
 */
public class Algorithm {

    /**
     * "常胜将军"
     *  21根火柴，两人轮流取，每人每次取1-4根，谁取最后一根则输。
     * @param args
     */
    public static void main(String[] args) {
        // 如何在计算机中分别表示两人的取火柴数。如何使用计算机模拟这一问题。--> 通过计算机实现这个游戏，可以线上玩。
        // 火柴总数
        int total=21,rest = total;
        Scanner scan = new Scanner(System.in);
        // 抽取次数
        int count = 1;
        while(rest>0){
            String name = count%2==0? "小华":"小明";
            System.out.printf("请%s输入您要抽取的火柴数：",name);
            // 从键盘接收数据
            Long num = scan.nextLong();
            if (num>4||num<1){
                System.out.println("每次至少取1根，最多取4根，请重新输入");
                continue;
            }
            rest-=num;
            if (rest<0){
                System.out.printf("最多抽取%d根火柴，请重新输入",rest);
                continue;
            }
            System.out.printf("%s抽取了%d根火柴，还剩%d根。\n",name,num,rest);
            if (rest==1){
                System.out.printf("%s赢\n",name);
                break;
            }
            count++;
        }
        scan.close();

    }

    /**
     * 体会：
     * 1. 看题目，第一眼觉得好难，我不会，我晕了。
     * 2. 相信自己，尝试解题。
     * 3. 分析现状，得出我共取4次，10根。即求出四个数字累加得10的数字组合即可。--> 原来也不难嘛！
     * 4. 编程调试。
     * 5. 评价结果。
     * 6. 寻找更优解。
     */
    public void howWin(){
        // 小明先取，小明每次分别取1、2、3、4根，我怎么取才能赢？
        // 21-1-2-3-4=11-1(剩下给小明取)=10根
        // 我共取4次，10根。
        // a+b+c+d=10 && 0<a<5 && 0<b<5 && 0<c<5 && 0<d<5
        int total = 10, min=1,max=5, num=0;
        for (int a = min; a < max; a++) {
            for (int b = min; b < max; b++) {
                for (int c = min; c < max; c++) {
                    for (int d = min; d < max; d++) {
                        if (a+b+c+d==total){
                            num++;
                            System.out.printf("我每次分别取%d,%d,%d,%d%n",a,b,c,d);
                        }
                    }
                }
            }
        }
        System.out.printf("总共有%s种方案%n",num);
    }
}
