package com.sun.thread.thread.communication;

/**
 * 使当前执行了join的线程，到调用了join方法线程结束之后在执行
 * 例如：执行了t1.join();这行代码的是main线程，t1线程调用了join方法
 * 那么mian线程将会等join线程执行完毕再执行，
 *
 * 如果join设置了等待时间，则会等等待时间过后，mian线程会再次执行
 * 如果等待时间过长，则t1线程执行完毕就会执行mian线程，而不会等时间结束
 * join方法也会释放锁，sleep方法不释放锁，wait也会释放锁
 *
 *
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                long start = System.currentTimeMillis();

                for(int i = 0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+i);
                }
//                long end = System.currentTimeMillis();
//                System.out.println(end-start);
            }
        });
        t1.start();
        long start = System.currentTimeMillis();
        t1.join(10000);
        long end = System.currentTimeMillis();
        System.out.println("主线程等待时间"+(end-start));
        System.out.println(Thread.currentThread().getName()+"线程执行结束了");
    }
}
