package com.sun.concurrent.volatile1;

/**
 * 测试volatile的原子性，
 *
 * synchronized保证原子性
 */
public class VolatileSynchronizedTest {
    public static  volatile  int num = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] thread = new Thread[10];
        for(int i=0;i<10;i++){
            thread[i] = new Thread(new Runnable() {
                @Override
                public void run() {
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    for(int i=0;i<10000;i++){
                        insert();
                    }
                }
            });
            thread[i].start();

        }
        for(Thread t : thread){
            t.join();
        }
        System.out.println(num);
    }

    private   static void insert() {
        num++;
    }
}
