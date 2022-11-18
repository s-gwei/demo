package com.sun.concurrent.volatile1;

public class VolatileTest {
    public static   volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable () {
            @Override
            public void run() {
                System.out.println("waiting data ");
                while (!flag){
                }
                System.out.println("end----------");
            }
        }).start();
        Thread.sleep(20);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("data1");
                flag=true;
                System.out.println("data2");
            }
        }).start();
    }
}
