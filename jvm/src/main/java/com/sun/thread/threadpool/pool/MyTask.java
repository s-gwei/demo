package com.sun.thread.threadpool.pool;

/**
 * author sungw
 *
 * @description
 * @date 2021/5/29
 */
class MyTask implements Runnable{

    private int i;
    public MyTask(int i){
        this.i=i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+","+i);
        try {
            //休眠1s，不会出现线程复用，说明整个执行完不需要1s，
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
