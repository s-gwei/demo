package com.sun.thread.thread.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三种实现线程安全的方式
 *
 *
 */
public class Test {
    public static void main(String[] args) {
        test01 test = new test01();
        new Thread(test,"A").start();
        new Thread(test,"B").start();
    }
}

class test01 implements Runnable{

    private  int balance = 0;

    Lock lock = new ReentrantLock();

    private AtomicInteger ab = new AtomicInteger(0);
    @Override
    public void run() {
        //synchronized加锁
//       synchronized (this){
//           for(int i=0;i<3;i++){
//               balance +=1000;
//               System.out.println(balance);
//           }
//       }
        //lock加锁
//        try {
//            lock.lock();
//            for(int i=0;i<3;i++){
//               balance +=1000;
//               System.out.println(balance);
//           }
//        }finally {
//            lock.unlock();
//        }
        //CAS无锁同步
           for(int i=0;i<3;i++) {
               ab.getAndAdd(1000);
               System.out.println(ab.get());
           }
    }
}