package com.sun.concurrent.cyc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 设置优先级，同步屏障到了，优先执行设置的线程
 *   CyclicBarrier cyclicBarrier = new CyclicBarrier(2,new A());
 */
public class CyclicBarrierTest01 {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2,new A());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"2");
            }
        },"线程A").start();
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"1");
    }
}

class A implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"---3");
    }
}