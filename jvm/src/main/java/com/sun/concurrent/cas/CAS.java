package com.sun.concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  原子性：
 *  i++问题的原子性：读 - 改 - 写 三步操作
 *  int temp = i
 *  temp = i+1;
 *  i = temp;
 *  原子变量：1.volatile保证可见性
 *          2.CAS算法保证原子性
 *          CAS包含三个操作数
 *          内存值  V
 *          预估值  A
 *          更新值  B
 *         当且仅当 V==A时，V = B,否则将不做任何操作
 */
public class CAS {
    public static void main(String[] args) {
        ThreadDemo02 st = new ThreadDemo02();
        for(int i = 0;i<10;i++){
            new Thread(st).start();
        }

    }
}

class ThreadDemo02 implements Runnable{

   //private int serialNumber = 0;
    //原子类，CAS是自旋锁的一种实现方式
    private AtomicInteger serialNumber =new AtomicInteger();//轻量级锁，无锁，自旋锁

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+";"+increased());
    }

    public int increased() {
       return serialNumber.getAndIncrement();
    }
}