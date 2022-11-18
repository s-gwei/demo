package com.sun.thread.threadpool.three;


import java.util.Date;

public class Test {
    public static void main(String[] args) {
        long start = new Date().getTime();
        System.out.println(start);
        long sum=0;
        for(int i = 0;i<1000000000;i++){
            sum+=i;
        }
        System.out.println(new Date().getTime() -start);
        System.out.println(sum);
    }
}
