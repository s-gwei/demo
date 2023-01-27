package com.sun.thread.thread.synchronized01;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo02 {
    public static void main(String[] args) {
        Demo02 Demo02 = new Demo02();
        new Thread(Demo02, "A").start();
        new Thread(Demo02, "B").start();
        new Thread(Demo02, "C").start();
    }
}

class Demo02 implements Runnable {

    private AtomicInteger a =new AtomicInteger(10);

//    private int a =10;
    public Object obj = new Object();

    @Override
    public void run() {
        while (true) {
//            synchronized (this) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                if (a.get() >0) {
                    System.out.println(Thread.currentThread().getName() + a.getAndDecrement());
                }else{
                     break;
                }
//            }
        }

    }
}