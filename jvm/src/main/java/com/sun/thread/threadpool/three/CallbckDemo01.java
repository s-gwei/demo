package com.sun.thread.threadpool.three;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallbckDemo01 {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for(int i = 0;i<10000;i++){
                  sum +=i;
                }
                return sum;
            }
        });
        new Thread(futureTask).start();
        try {
            int sum = futureTask.get();
            System.out.println("futureTask1求和为"+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"执行完毕");
    }
}
