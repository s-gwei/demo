package com.sun.thread.thread.communication;
/**
 * 交替打印1-100，
 * wait()和notify()方法
 * 但是wait()和notify()不能选择唤醒某个线程，
 * 也就是在多个线程环境中，不能按照指定顺序执行线程
 */
public class CommunicationTest {
    public static void main(String[] args) {
        AlternateDemo st = new AlternateDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    st.loopA(i);
                }
            }
        },"线程A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    st.loopA(i);
                }
            }
        },"线程B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    st.loopA(i);

                }
            }
        },"线程C").start();
    }
}


class AlternateDemo{
    private static volatile int number = 1;//标记正在执行的线程
    Object obj = new Object();

    public void loopA(int tap){
        synchronized (obj){
            //1.判断此时线程标记
            if(number !=1){
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //2.标记
//            for(int i=0;i<1;i++){
                System.out.println(Thread.currentThread().getName()+"   "+tap);
//            }
            //切换到下个线程
            number =2;
            obj.notifyAll();
            //1.判断此时线程标记
            if(number !=2){
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //2.标记
//            for(int i=0;i<1;i++){
            System.out.println(Thread.currentThread().getName()+"   "+tap);
//            }
            //切换到下个线程
            number =3;
            obj.notifyAll();
            //1.判断此时线程标记
            if(number !=3){
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //2.标记
//            for(int i=0;i<1;i++){
            System.out.println(Thread.currentThread().getName()+"   "+tap);
//            }
            //切换到下个线程
            number =1;
            obj.notifyAll();
        }

    }



}