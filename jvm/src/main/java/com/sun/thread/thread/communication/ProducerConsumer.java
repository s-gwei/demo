package com.sun.thread.thread.communication;

/**
 * 线程通信实现消费者/生产者模式
 * wait,notify
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        Clrek clrek = new Clrek();
        Product  p1 = new Product(clrek);
        new Thread(p1,"生产者1").start();
        Consumer c1 = new Consumer(clrek);
        new Thread(c1,"消费者1").start();
        new Thread(c1,"消费者2").start();
        new Thread(c1,"消费者3").start();
        new Thread(c1,"消费者4").start();
    }
}

class Clrek{


    private int productCount = 0;
    //生产商品
    public synchronized void getProduct() throws InterruptedException {
        if(productCount < 2000){
            productCount++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + productCount + "个商品");
            notify();
        } else {
            wait();
        }
    }

    //消费商品
    public synchronized void getConsumer() throws InterruptedException {
        if(productCount > 0){

            System.out.println(Thread.currentThread().getName()+"开始消费第"+productCount+"个商品");
            productCount--;
            notify();
        }else{
            wait();
        }
    }
}

/**
 * 生产者
 */
class Product implements  Runnable{

    private Clrek clrek;

    public Product(Clrek clrek){
        this.clrek = clrek;
    }

    @Override
    public void run() {
          System.out.println(Thread.currentThread().getName()+"开始生产商品");
      while (true){
          try {
              Thread.sleep(1);
              clrek.getProduct();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
    }
}

/*
消费者
 */
class Consumer implements  Runnable{

    private Clrek clrek;

    public Consumer(Clrek clrek){
        this.clrek = clrek;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始消费商品");
        while (true){
            try {
                Thread.sleep(20);
                clrek.getConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
