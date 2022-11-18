package com.sun.concurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest01 {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(5);
        Demo demo = new Demo(countDownLatch);
        for(int i=0;i<5;i++){
            new Thread(demo, String.valueOf(i)).start();
        }


        //await()使主线程等待，如果countDownLatch不为0，主线程不会继续执行
        countDownLatch.await();
        System.out.println("一共用了"+(System.currentTimeMillis()-start));
    }
}

class Demo implements Runnable{

    private CountDownLatch countDownLatch ;

    public Demo(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
//        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName());
//        }
//countDown()使countDownLatch--；
        countDownLatch.countDown();
    }
}