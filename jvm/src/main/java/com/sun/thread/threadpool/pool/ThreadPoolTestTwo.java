package com.sun.thread.threadpool.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * 用时：12668
 * 大小100000
 * 创建10万个线程，创建线程需要时间，线程之间切换上下文也需要时间
 */
public class ThreadPoolTestTwo {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<100000;i++){
            Thread thread = new Thread(){
                @Override
                public void run(){
                    list.add(random.nextInt());
                }
            };
            thread.start();
            thread.join();
        }

        System.out.println("用时："+(System.currentTimeMillis()-start));
        System.out.println("大小"+list.size());
    }
}
