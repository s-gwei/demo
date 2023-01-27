package com.sun.concurrent.cyc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 让一组线程到达某个屏障，然后被阻塞，
 * 一直到最后一个线程到达屏障，然后屏障开放，所有被阻塞的线程继续执行，
 * 计数器与线程数相等。
 * 到达第二个屏障... 到达第三个屏障
 * 设置5个线程，4个屏障
 */
public class CyclicBarrierTest02 {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

    public static void main(String[] args) {
        for (int i = 1;i<=5;i++){
            new Thread(new Cyclic(cyclicBarrier),"选手"+i).start();
        }
        System.out.println("mian is end");
    }
}
class Cyclic implements Runnable{

    private CyclicBarrier cyclicBarrier;
    public Cyclic(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run() {
        for(int i=1;i<=4;i++){
            System.out.println(Thread.currentThread().getName()+"跨过了第"+i+"个屏障");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}