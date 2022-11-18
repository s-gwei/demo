package com.sun.concurrent.volatile1;

import java.util.HashSet;

/**
 * 并发有序性：
 * 多个线程执行时会有指令重排
 * 会出现四种情况[a=1;b=1, a=0;b=0, a=0;b=1, a=1;b=0]
 * 因为指令不是按顺序执行的
 */
public class VolatileOrderOne {
    public static       int a=0,b=0;
    public static      int x=0,y=0;
    public static void main(String[] args) throws InterruptedException {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<10000000;i++){
             a=0;
             b=0;
             x=0;
             y=0;
            Thread t1 =   new Thread(new Runnable() {
                @Override
                public void run() {
                    a=y;//3
                    x=1;//1
                }
            });
            Thread t2 =   new Thread(new Runnable() {
                @Override
                public void run() {
                    b=x;//4
                    y=1;//2
                }
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            set.add("a="+a+";b="+b);
            System.out.println(i+";"+set);
        }
    }
}
