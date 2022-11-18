package com.sun.thread.threadpool.three;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的第三种方式：实现callable接口，相较于runable接口，方法有返回值，
 * 当线程在运行过程中，get方法未执行
 */
public class TestCallable {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        FutureTask<Long> result = new FutureTask<Long>(threadDemo);

        System.out.println("主线程执行，在result.get()之前，主线程正常执行");

        //runable接口，主线程不会等分线程执行完毕在执行。
        ThreadDemoTwo threadDemoTwo = new ThreadDemoTwo();
        new Thread(threadDemoTwo).start();
        //runable接口，主线程不会等分线程执行完毕在执行。
        ThreadDemothree threadDemothree = new ThreadDemothree();
        new Thread(threadDemothree).start();

        try {
            // result.get()方法会使主线程等待该线程执行完毕，获取到返回值，相当于自带闭锁
            //但别别的实现runable接口的线程不会等待该分线程执行完毕在执行
            Long a = result.get();
            System.out.println("Callable接口值："+a);
            System.out.println("在result.get()后，主线程等待result执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完毕");

    }
}

class ThreadDemo implements Callable<Long>{

    @Override
    public Long call() throws Exception {
        long sum=0;
        for(long i=0;i<10000000000l;i++){
//            System.out.println(i);
            sum+=i;
        }
        return sum;
    }
}

class ThreadDemoTwo implements Runnable{

    @Override
    public void run() {
        long sum = 0;
        for(long i=0;i<10000000000l;i++){
//            System.out.println(i);
            sum+=i;
        }
        System.out.println("ThreadDemoTwo："+sum);
    }
}

class ThreadDemothree implements Runnable{

    @Override
    public void run() {
        long sum = 0;
        for(long i=0;i<10000000000l;i++){
//            System.out.println(i);
            sum+=i;
        }
        System.out.println("ThreadDemothree："+sum);
    }
}