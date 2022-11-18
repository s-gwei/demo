package com.sun.thread.thread.test;

public class TestThread {
    public static void main(String[] args) {
        ThreadDemo st = new ThreadDemo();
       new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try {
                        st.loopA();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"线程A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try {
                        st.loopB();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"线程B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try {
                        st.loopC();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"线程C").start();
    }

}

class ThreadDemo {
    private int number = 1;

    public Object obj1 = new Object();
    public Object obj2 = new Object();
    public Object obj3 = new Object();

    public void loopA() throws InterruptedException {
        if(number != 1){
            obj1.wait();
        }
        //2.标记
        for(int i=0;i<1;i++){
            System.out.println(Thread.currentThread().getName()+"   "+i+"   ");
        }
        number =2;
        obj2.notify();
    }
    public void loopB() throws InterruptedException {
        if(number != 2){
            obj2.wait();
        }
        //2.标记
        for(int i=0;i<1;i++){
            System.out.println(Thread.currentThread().getName()+"   "+i+"   ");
        }
        number =3;
        obj3.notify();
    }
    public void loopC() throws InterruptedException {
        if(number != 3){
            obj3.wait();
        }
        //2.标记
        for(int i=0;i<1;i++){
            System.out.println(Thread.currentThread().getName()+"   "+i+"   ");
        }
        number =1;
        obj1.notify();
    }
}