package com.sun.thread.threadpool.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 用时：35
 * 大小100000,线程池中只有一个线程，这个线程执行可10万次
 */
public class ThreadPoolTestOne {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for(int i=0;i<100000000;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(1,TimeUnit.MINUTES);
        System.out.println("用时："+(System.currentTimeMillis()-start));
        System.out.println("大小"+list.size());


    }
}
