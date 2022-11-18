package com.sun.thread.thread.communication;


/**
 * 线程通信实现消费者/生产者模式
 * wait,notify
 * 另一种方式
 */
public class ProducerConsumerTest {
    public static void main(String[] args) {
        ClrekTest clrekTest = new ClrekTest();
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    while(true){
                        clrekTest.getProduct();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"生产者1号").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){
                        clrekTest.getConsumer();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者1号").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){
                        clrekTest.getConsumer();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者2号").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){
                        clrekTest.getConsumer();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者3号").start();
    }
}

class ClrekTest{


    private int productCount = 0;
    //生产商品
    public synchronized void getProduct() throws InterruptedException {
        if(productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + productCount + "个商品");
//            notify();
        } else {
//            wait();
        }
    }

    //消费商品
    public synchronized void getConsumer() throws InterruptedException {
        if(productCount > 0){

            System.out.println(Thread.currentThread().getName()+"开始消费第"+productCount+"个商品");
            productCount--;
//            notify();
        }else{
//            wait();
        }
    }
}