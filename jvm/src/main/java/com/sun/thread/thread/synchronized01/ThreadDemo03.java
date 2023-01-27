package com.sun.thread.thread.synchronized01;

public class ThreadDemo03 {
    public static void main(String[] args) {
//        Demo03 Demo03 = new Demo03();
//        new Thread(Demo03,"C").start();
//        new Thread(Demo03,"B").start();
//        new Thread(Demo03,"A").start();
        //创建多个对象实现多线程，需要将对象全局变量转变为类的全局变量
        Demo03 Demo04 = new Demo03();
        Demo03 Demo05 = new Demo03();
        Demo03 Demo06 = new Demo03();
        new Thread(Demo04,"C").start();
        new Thread(Demo05,"B").start();
        new Thread(Demo06,"A").start();

    }
}

class Demo03 implements Runnable{

//    private  int ticket = 10000;
    private  static int ticket = 100;
    @Override
    public void run() {
        //卖票方法
        while(true){
        sale();
        }
    }

//    private synchronized void sale() {
        private  static synchronized void sale() {

            if(ticket>0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"卖了第"+ticket+"张票");
                ticket--;
            }

    }
}