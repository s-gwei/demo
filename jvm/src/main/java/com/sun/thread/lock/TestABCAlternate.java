package com.sun.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程的交替打印问题
 * ABC三个线程交替打印
 */
public class TestABCAlternate {
    public static void main(String[] args) {
        AlternateDemo st = new AlternateDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    st.loopA(i);
                }
            }
        },"线程A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    st.loopB(i);
                }
            }
        },"线程B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    st.loopC(i);
                }
            }
        },"线程C").start();
    }

}

class AlternateDemo{
    private int number = 1;//标记正在执行的线程

    private Lock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();

    private Condition condition2 = lock.newCondition();

    private Condition condition3 = lock.newCondition();


    public void loopA(int tap){
        lock.lock();
        try{
            //1.判断此时线程标记
            if(number !=1){
                condition1.await();
            }
            //2.标记
            for(int i=0;i<tap;i++){
                System.out.println(Thread.currentThread().getName()+"   "+i+"   "+tap);
            }
            //切换到下个线程
            number =2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void loopB(int tap){
        lock.lock();
        try{
            //1.判断此时线程标记
            if(number !=2){
                condition2.await();
            }
            //2.标记
            for(int i=0;i<tap;i++){
                System.out.println(Thread.currentThread().getName()+"   "+i+"   "+tap);
            }
            //切换到下个线程
            number =3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC(int tap){
        lock.lock();
        try{
            //1.判断此时线程标记
            if(number !=3){
                condition3.await();
            }
            //2.标记
            for(int i=0;i<tap;i++){
                System.out.println(Thread.currentThread().getName()+"   "+i+"   "+tap);
            }
            //切换到下个线程
            System.out.println("循环一次完成--------------");
            number =1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
