package com.sun.thread.threadpool.pool;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor1 = Executors.newCachedThreadPool();//最快,cpu100%
        ExecutorService executor2 = Executors.newFixedThreadPool(5);//慢,OOM
        ExecutorService executor3 = Executors.newSingleThreadExecutor();//最慢,OOM

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                10, 20, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),new ThreadPoolExecutor.CallerRunsPolicy());
//用于被拒绝任务的处理程序，它直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务。
        long start = System.currentTimeMillis();
        for(int i=0;i<100;i++){
//            executor2.execute(new MyTask(i));
//            threadPool.execute(new MyTask(i));
            executor2.execute(new MyTask(i));
        }

        threadPool.shutdown();
//        Thread.currentThread().join();
        System.out.println("用时："+(System.currentTimeMillis()-start));
    }
}

