package com.sun.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用于解决同步线程安全性问题：
 * 一，synchronized
 * 同步方法
 * 同步代码块
 * 二，jdk1.5以后
 * 显式锁，通过lock()方法上锁，unlock方法释放锁
 */
public class TestLock {
    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();
        new Thread(lockDemo,"1号窗口").start();
        new Thread(lockDemo,"2号窗口").start();
        new Thread(lockDemo,"3号窗口").start();
//        ThreadPoolExecutor pool = new ThreadPoolExecutor(
//                3, 3, 0, TimeUnit.SECONDS,
//                new ArrayBlockingQueue<Runnable>(3), new ThreadPoolExecutor.CallerRunsPolicy());
//        for(int i=0;i<10;i++){
//            pool.execute(lockDemo);
//        }
//        pool.shutdown();
    }
}

class LockDemo implements Runnable {

    private int ticket = 100;

    private Lock lock = new ReentrantLock();

        @Override
    public void run() {
        while (true) {
            //加锁一定要在try,final中，线程异常执行final，释放锁
            try {
                lock.lock();
                if (ticket > 0) {
                    Thread.sleep(20);
                    System.out.println(Thread.currentThread().getName() + "卖了第" + ticket + "张票");
                    ticket--;
                }else{
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
//    @Override
//    public void run() {
//        while (true) {
//            synchronized (this) {
//                if (ticket > 0) {
//                    try {
//                        Thread.sleep(20);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + "卖了第" + ticket + "张票");
//                    ticket--;
//                }
//            }
//
//        }
//
//    }
}