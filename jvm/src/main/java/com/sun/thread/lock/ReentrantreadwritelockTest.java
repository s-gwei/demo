package com.sun.thread.lock;


import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ReentrantreadwritelockTest {
    public static void main(String[] args) {
        Test test = new Test();
        //写写互斥
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                test.write();
//            }
//        }, "A").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                test.write();
//            }
//        }, "B").start();
        //读读共享
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                test.read();
//            }
//        }, "A").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                test.read();
//            }
//        }, "B").start();
        //读写互斥
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.read();
            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.write();
            }
        }, "B").start();
    }
}

class Test {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * ReentrantReadWriteLocK
     * 同一时刻允许多个线程读取数据，但是只允许一个线程改写数据
     */
    public void read() {
        try {
            lock.readLock().lock();

            System.out.println(Thread.currentThread().getName() + "获取读锁" + System.currentTimeMillis());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write() {
        try {
            lock.writeLock().lock();

            System.out.println(Thread.currentThread().getName() + "获取写锁" + System.currentTimeMillis());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}