package com.sun.concurrent.volatile1;

/**
 * 多线程之间的共享变量不可见
 */
public class Test {

//    public static  volatile boolean flag = false;
    public static   boolean flag = false;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!flag){
                }
                System.out.println("线程2接收到了flag的变化");
            }
        }).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("线程1改变了flag");
                flag = true;
            }
        }).start();

    }
}
