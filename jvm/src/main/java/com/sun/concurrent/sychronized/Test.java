package com.sun.concurrent.sychronized;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 类创建占用字节
 * synchronized锁变化使对象头锁标志位变化
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        A  a = new A();
        //class Metadate Address

//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (a){
//                    try {
//                        Thread.sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        t1.start();
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (a){
//                    try {
//                        Thread.sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        t2.start();
//        t1.join();
//        t2.join();
//        System.out.println(a.hashCode());
//        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }
    public    void test(){
        /**
         * java中有哪些锁
         * 公平锁，非公平锁，读写锁，共享锁，互斥锁，可重入锁，
         * 偏向锁，轻量级锁，重量级锁
         *synchronized给对象上锁，而不是方法或者代码块
         *
         */
        ReentrantLock lock = new ReentrantLock();
        try{
            lock.lock();
            System.out.println("xxx");
        }finally {
            lock.unlock();
        }
        /**

         */

        synchronized (this){
            System.out.println("xxx");
        }

    }
}

class A {
    public byte[] a = new byte[1024];
    public void test(){
    }
}