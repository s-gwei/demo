package com.sun.thread.thread.communication;

import com.sun.thread.thread.synchronized01.ThreadDemo03;

/**
 * 线程A,B交替打印12a34b...5152z
 */
public class Communication04 {
    public static void main(String[] args) {

        ThreadDemo04 threadDemo04 = new ThreadDemo04();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    threadDemo04.loopA();
                }
            }
        }, "线程a").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    threadDemo04.loopB();
                }
            }
        }, "线程B").start();
    }

}

class ThreadDemo04 {
    public boolean flag = true;
    public int number = 1;
    public char chared = 'a';

    public void loopA() {
        synchronized (this) {
            notify();
            while (!flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number <= 26) {
                System.out.println(number * 2 - 1);
                System.out.println(number * 2);
            }
            number++;
            flag = false;
        }
    }

    public void loopB() {
        synchronized (this) {
            notify();
            while (flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number <= 27) {
                System.out.println(chared);
            }
            chared++;
            flag = true;
        }
    }
}
