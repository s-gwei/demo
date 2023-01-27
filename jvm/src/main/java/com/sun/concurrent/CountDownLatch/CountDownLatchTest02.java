package com.sun.concurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 一个线程等待其他线程执行完之后再执行，相当于加强版的join，
 * 在初始化CountDownLatch是需要设定计数器的数值
 * （计数器数据不一定跟线程数相同，但是一定计数器的值一定是要小于等于线程数，否则会一直等待下去
 * 一个线程中可以进行多次扣减。当计数器扣减至0时才可继续向下执行）
 * 但是CountDownLatch是一次性的，只要计数器减为0，再次调用await时，会直接通过
 */
public class CountDownLatchTest02 {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i=0;i<500;i++){
            new Thread(new CountDownLatchDemo(countDownLatch,i)).start();
        }
        countDownLatch.await();
        System.out.println("所有玩家已准备，游戏开始");
    }
}

class CountDownLatchDemo implements Runnable {
    private CountDownLatch countDownLatch;

    private int index;
    public CountDownLatchDemo(CountDownLatch countDownLatch, int index) {
        this.countDownLatch = countDownLatch;
        this.index = index;
    }

    @Override
    public void run() {
        System.out.println("玩家"+index+"已准备完成");
        countDownLatch.countDown();
    }
}
