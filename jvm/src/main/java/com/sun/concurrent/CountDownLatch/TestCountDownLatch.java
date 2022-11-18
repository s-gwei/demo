package com.sun.concurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch:一个线程在等待另外一些线程完成各自工作之后，再继续执行。
 *
 * CountDownLatch是一个同步工具类，用来协调多个线程之间的同步，或者说起到线程之间的通信（而不是用作互斥的作用）。
 *
 * CountDownLatch能够使一个线程在等待另外一些线程完成各自工作之后，再继续执行。使用一个计数器进行实现。
 *
 * 计数器初始值为线程的数量。当每一个线程完成自己任务后，计数器的值就会减一。
 *
 * 当计数器的值为0时，表示所有的线程都已经完成一些任务，然后在CountDownLatch上等待的线程就可以恢复执行接下来的任务。
 */
public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        LatchDemo latchDemo = new LatchDemo(countDownLatch);
//        LatchDemo latchDemo = new LatchDemo();

        long start = System.currentTimeMillis();

            new Thread(latchDemo,"线程A").start();

            countDownLatch.await();

        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start));
    }
}

class LatchDemo implements Runnable{

    private CountDownLatch countDownLatch ;

    public LatchDemo(CountDownLatch countDownLatch){

        this.countDownLatch =  countDownLatch;
    }
    @Override
    public void run() {
        try {
            for(int i=0;i<5;i++){
                if(i%2 == 0){
                    System.out.println(i);
                }
            }
        }finally {
            countDownLatch.countDown();
        }

    }
}
