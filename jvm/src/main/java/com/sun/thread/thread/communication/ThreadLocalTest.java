package com.sun.thread.thread.communication;

/**
 * 线程局部变量
 * get(),set(),remove()方法
 */
public class ThreadLocalTest {
    public static  ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        // 重写这个方法，可以修改“线程变量”的初始值，默认是null
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(1);
                threadLocal.set(3);
//                threadLocal.remove();
                System.out.println(Thread.currentThread().getName()+"的线程局部变量值为:"+threadLocal.get());
            }
        },"线程A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(2);
                System.out.println(Thread.currentThread().getName()+"的线程局部变量值为:"+threadLocal.get());
            }
        },"线程B").start();
        System.out.println(Thread.currentThread().getName()+"线程局部变量值为:"+threadLocal.get());

    }
}
