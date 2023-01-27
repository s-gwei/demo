package com.sun.thread.thread.communication;

import lombok.SneakyThrows;

/**
 * A，B,C交替打印1-100，
 * 使用while，不要用if，因为if会在接下去的代码上继续执行
 * wait()和notify()方法
 */
public class Communication02 {
    public static void main(String[] args) {
        ThreadDemo02 threadDemo02 = new ThreadDemo02();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    threadDemo02.loopA();
                }
            }
        }, "线程A").start();
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true) {
                    threadDemo02.loopB();
                }
            }
        }, "线程B").start();
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true) {
                    threadDemo02.loopC();
                }
            }
        }, "线程C").start();
    }
}

class ThreadDemo02 {

    private static volatile int number = 1;

    private static volatile int flag = 1;

    public void loopA(){
        synchronized (this) {
            while (flag != 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number <= 100) {
                System.out.println(Thread.currentThread().getName() + "打印了" + number);
                number++;
            }
            flag = 2;
            notifyAll();
        }
    }

    public void loopB() throws InterruptedException {
        synchronized (this) {
            while (flag != 2) {
                wait();
            }
            if (number <= 100) {
                System.out.println(Thread.currentThread().getName() + "打印了" + number);
                number++;
            }
            flag = 3;
            notifyAll();
        }
    }

    public void loopC() throws InterruptedException {
        synchronized (this) {
            while (flag != 3) {
                wait();
            }
            if (number <= 100) {
                System.out.println(Thread.currentThread().getName() + "打印了" + number);
                number++;
            }
            flag = 1;
            notifyAll();
        }
    }

}