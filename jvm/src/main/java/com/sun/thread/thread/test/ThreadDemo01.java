package com.sun.thread.thread.test;

/**
 * 线程A执行5秒，线程B执行3秒，多线程同时执行，所需时间应该稍微小于8秒
 * 线程A执行50秒，线程B执行30秒，多线程同时执行，所需时间应该稍微大于50秒，远小于80秒
 * 线程创建需要时间，执行时间断，时间都会花在线程创建上，不适合用多线程
 */
public class ThreadDemo01 {
    public static void main(String[] args) {
        Demo01 Demo01 = new Demo01();
        new Thread(Demo01,"A").start();
        long start = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"---"+System.currentTimeMillis());
        int sum = 0;
        for(long i=0;i<100000000;i++){
            sum++;
        }
        System.out.println("main耗时"+System.currentTimeMillis()+"---"+(System.currentTimeMillis()-start));
    }
}

class Demo01 implements Runnable{

    @Override
    public void run() {
        long start = System.currentTimeMillis();
//        System.out.println(Thread.currentThread().getName()+"---"+System.currentTimeMillis());
        int sum = 0;
        for(long i=0;i<100000000;i++){
            sum++;
        }
        System.out.println(Thread.currentThread().getName()+"耗时"+System.currentTimeMillis()+"---"+(System.currentTimeMillis()-start));
    }
}