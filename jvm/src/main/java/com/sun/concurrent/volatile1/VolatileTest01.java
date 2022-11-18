package com.sun.concurrent.volatile1;

/**
 * volatile:当多个线程共同操作共享数据时，保证了数据的可见性，
 * 相当于一种轻量级synchronized锁，
 * 但是它不能保证原子性，不具备互斥性
 * synchronized关键字具有并发编程的三大特性：有序性，可见性，原子性
 */
public class VolatileTest01 {
    public static void main(String[] args) {
        ThreadDemo st = new ThreadDemo();
        new Thread(st).start();
        while (true) {
            synchronized (st){
                if (st.isFlag()) {
                    System.out.println("获取到flag的值:" + st.isFlag());
                    st.setFlag(false);
                }
            }

        }
    }
}

class ThreadDemo implements Runnable {
    private  boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag = " + isFlag());
    }

}