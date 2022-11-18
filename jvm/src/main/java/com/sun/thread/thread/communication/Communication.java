package com.sun.thread.thread.communication;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印1-100，
 * wait()和notify()方法
 */
public class Communication {
    public static void main(String[] args) {
        Number number = new Number();
//        Thread st = new Thread(number,"线程A");
//        st.start();
        new Thread(number,"线程A").start();
        new Thread(number,"线程B").start();


//        new Thread(number,"线程C").start();
    }
}

class Number implements Runnable{

    private  int number = 1;

    private  int flag = 1;

    Lock lock = new ReentrantLock();
    @Override
    public void run() {

        while (true){
            synchronized (this){
                notify();
                if(number<=10){
                    System.out.println(Thread.currentThread().getName()+"执行了第"+number+"次");
                    number++;
                }else {
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // wait(),notify()只能在同步方法或者同步代码块中，调用对象是锁对象
//            try {
//                lock.lock();
//                                if(number<100){
//                    System.out.println(Thread.currentThread().getName()+"执行了第"+number+"次");
//                    number++;
//                }else {
//                    break;
//                }
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }finally {
//                lock.unlock();
//            }

        }

    }
}