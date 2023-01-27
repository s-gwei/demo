package com.sun.thread.thread.communication;

import lombok.SneakyThrows;

/**
 * A，B交替打印1-100，
 * wait()和notify()方法
 */
public class Communication01 {
    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        new Thread(demo01,"线程A").start();
        new Thread(demo01,"线程B").start();
    }
}
class Demo01 implements Runnable{

    public int number = 1;

    @Override
    public void run() {
        while(true){
            synchronized (this){
                notify();
                if(number<=100){
                    System.out.println(Thread.currentThread().getName()+"打印了"+number);
                    number++;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
