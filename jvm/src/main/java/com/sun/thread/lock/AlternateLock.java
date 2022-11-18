package com.sun.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Condition对象监视器，超过两个线程时，应该尽量保证一个Condition只监视一个线程，
 * 也就是一个代码块只会被一个线程执行，否则无法保证选择性通知
 *
 * 两个线程只需要一个对象监视器Condition，执行代码块也可以相同，
 * 三个线程必须要三个对象监视器Condition，并且保证每个对象监视器，只监视同一个线程。
 *
 * Condition的使用必须在lock方法之后，也就是同步代码块中
 */
public class AlternateLock {
    public static void main(String[] args) {
        Alternate alternate = new Alternate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                alternate.loopA();
            }
        },"线程A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                alternate.loopB();
            }
        },"线程B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                alternate.loopC();
            }
        },"线程C").start();
    }
}

class Alternate {

    public Lock lock = new ReentrantLock();

    private int number = 1;

    private int ticket = 100;

    //对象监视器，再lock中使用
    public Condition condition1 = lock.newCondition();

    public Condition condition2 = lock.newCondition();

    public Condition condition3 = lock.newCondition();

    public void loopA(){
        while (true){
            if(ticket>2){
                try{
                    lock.lock();
                    if(number != 1){
//                        线程B到执行到这里，执行await，线程B进入阻塞状态，
//                         将condition1,与线程B绑定，condition1执行signal，线程B进入就绪状态
                        condition1.await();
                    }
                    System.out.println(Thread.currentThread().getName()+"卖了第"+ticket+"张票");
                    ticket--;
                    number=2;
//                    condition1.await();
                    condition2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }else {
                break;
            }
        }
    }
    public void loopB(){
        while (true){
            if(ticket>2){
                try{
                    lock.lock();
                    if(number != 2){
                        condition2.await();
                    }
                    System.out.println(Thread.currentThread().getName()+"卖了第"+ticket+"张票");
                    ticket--;
                    number=3;
                    condition3.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }else {
                break;
            }
        }
    }

    public void loopC(){
        while (true){
            if(ticket>2){
                try{
                    lock.lock();
                    if(number != 3){
                        condition3.await();
                    }
                    System.out.println(Thread.currentThread().getName()+"卖了第"+ticket+"张票");
                    ticket--;
                    number=1;
                    condition1.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }else {
                break;
            }
        }
    }

}