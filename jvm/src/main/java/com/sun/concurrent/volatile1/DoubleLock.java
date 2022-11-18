package com.sun.concurrent.volatile1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 双重检测锁实现单例模式
 * 并发条件下实现单例模式：双重检测锁，使用的静止指令重排序
 * 双重检测锁也还是会出现线程不安全问题，与类的创建有关，可以使用volatile关键字，
 *
 */
public class DoubleLock {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<FutureTask> list = new ArrayList<FutureTask>();
        for(int i=0;i<10000;i++){
            FutureTask<DoubleLock> task = new FutureTask(new Callable<DoubleLock>() {
                @Override
                public DoubleLock call() throws Exception {
                    Thread.sleep(2000);
//                    com.sun.concurrent.volatile1.DoubleLock@66d3c617
//                    com.sun.concurrent.volatile1.DoubleLock@5e481248
//                    确实创建了两个不同的实例
                    return DoubleLock.get();

//                    com.sun.concurrent.volatile1.DoubleLock@5e481248
//                    只创建了一个实例
//                    return DoubleLock.getDouble();

                }
            });
            new Thread(task).start();
            list.add(task);
        }
        for(FutureTask FutureTask :list){
            DoubleLock task = (DoubleLock) FutureTask.get();
            System.out.println(task);
        }
    }
    public static volatile DoubleLock instance = null;
    /**
     *  先给a赋值为0，再赋值为6，两步操作重排，
     *  赋值为0后，出现，指令重排问题，
     *  被其他线程调用，此时该线程获取到值为0
     */


    private  volatile int a =6;

    public DoubleLock(){

    }
    //获取单例

    public static DoubleLock get(){
        if(instance == null){
            //多个线程执行到if时，线程A获取到锁，创建了实例，线程B也会创建实例

            synchronized (DoubleLock.class){
                instance = new DoubleLock();
            }

        }
        return instance;
    }
 // 双重判断锁
    public static DoubleLock getDouble(){
            //多个线程执行到if时，线程A获取到锁，创建了实例，线程B也会创建实例
          //将锁放在if之前。
        if(instance == null) {
            synchronized (DoubleLock.class) {
                if (instance == null) {
                    instance = new DoubleLock();
                }
            }
        }
        return instance;
    }
}
