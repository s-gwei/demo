package com.sun.concurrent.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * java中的原子操作类，底层使用CAS无锁机制实现线程安全，
 * 常用的AtomicIntger,AtomicLong
 */
public class AtomicTest {
    public static void main(String[] args) {
        //使用CountDownLatch使主线程等待两个分线程执行完毕在执行
        CountDownLatch countDownLatch = new CountDownLatch(2);
        AutoInteger autoInteger = new AutoInteger(countDownLatch);
        new Thread(autoInteger,"线程A").start();
        new Thread(autoInteger,"线程B").start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(autoInteger.getAtomicInteger());
    }
}

class AutoInteger implements  Runnable{

    CountDownLatch countDownLatch ;
    AtomicInteger atomicInteger = new AtomicInteger();

    public AutoInteger(CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;
    }
    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public void setAtomicInteger(AtomicInteger atomicInteger) {
        this.atomicInteger = atomicInteger;
    }

    /**
     *  1, atomicInteger.incrementAndGet()自增+1；
     *   2, atomicInteger.incrementAndGet()自减-1；
     *    3,atomicInteger.compareAndSet(-20,99);CAS无锁算法
     *    如果atomicInteger的值为-20，就将其改为99；
     *   4,atomicInteger.getAndAdd(20);
     *   先获取atomicInteger的值，再加上20
     */


    @Override
    public void run() {
        for(int i=0;i<10;i++){
//            System.out.println(Thread.currentThread().getName()+atomicInteger.incrementAndGet());
        System.out.println(Thread.currentThread().getName()+atomicInteger.decrementAndGet());
//            atomicInteger.decrementAndGet();
            atomicInteger.getAndAdd(20);
            atomicInteger.compareAndSet(10,20);//比较内存地址
        }
        atomicInteger.compareAndSet(-20,99);
        countDownLatch.countDown();
    }
}