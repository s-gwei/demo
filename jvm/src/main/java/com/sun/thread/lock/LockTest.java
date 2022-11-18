package com.sun.thread.lock;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        /**
         * lock--加锁成功--正常返回
         * 加锁失败--阻塞
         * 改变一个变量值
         */
        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        System.out.println(1);
        lock.unlock();
        //加锁是给对象加锁,而不是方法,改变对象头的某个部分
        synchronized (new String()){
            //无锁,不可偏向状态
            //无锁,可偏向
            //偏向锁
            //轻量级锁
            //重量级锁,synchronized锁膨胀,且不可逆
            System.out.println(1);
        }
        LockSupport.park();
        LockSupport.unpark(new Thread());
    }
}
