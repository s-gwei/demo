package com.sun.thread.threadpool.three;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws InterruptedException {
        FutureTask<Long> futureTask1 = new FutureTask<>(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                long sum = 0l;
                for(long i=0;i<100000000l;i++){
                    sum += i;
                }
                return sum;
            }
        });
        new Thread(futureTask1).start();
        try {
           long sum =  futureTask1.get();
            System.out.println("futureTask1求和为"+sum);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        FutureTask<Long> futureTask = new FutureTask(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return sum();
            }

            private Long sum() {
                long sum=0;
                for(long i=0;i<Integer.MAX_VALUE;i++){
                    sum+=i;
                }
                return sum;
            }
        });
        new Thread(futureTask).start();

        try {
            Long sum =  futureTask.get();
            System.out.println("Callable线程求和："+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完毕");
        Thread s1 =   new Thread(new Runnable() {
            @Override
            public void run() {
                long sum=0;
                for(long i=0;i<100000000l;i++){
                    sum+=i;

                }
                System.out.println("分线程求和："+sum);
            }
        });


        s1.start();
        System.out.println("主线程正常执行");
        //可以通过join的方式，使主线程在分线程结束后，在执行
        s1.join();
        System.out.println("主线程结束");
    }
}
