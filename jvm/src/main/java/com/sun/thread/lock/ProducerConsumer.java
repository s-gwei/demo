package com.sun.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition实现生产者消费者
 */
public class ProducerConsumer {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始消费商品");
                while (true) {
                    clerk.getProduct();
                }
            }
        }, "生产者1号").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始生产商品");
                while (true) {
                    clerk.getConsumer();
                }
            }
        }, "消费者1号").start();


    }
}

class Clerk {

    private int productCount = 0;//商品数量

    private Lock lock = new ReentrantLock();

    Condition condition1 = lock.newCondition();

    //生产商品
    public void getProduct() {

        try {
            Thread.sleep(100);
            lock.lock();
//                condition1.signalAll();
            condition1.signal();
            if (productCount < 20) {
                productCount++;
                System.out.println(Thread.currentThread().getName() + "正在生产第" + productCount + "件商品");
            } else {
                condition1.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    //消费商品
    public void getConsumer() {
        try {
            Thread.sleep(100);
            lock.lock();
            condition1.signal();
//                condition1.signalAll();
            if (productCount > 0) {
                System.out.println(Thread.currentThread().getName() + "正在消费第" + productCount + "件商品");
                productCount--;
            } else {
                condition1.await();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

}