package com.sun.thread.threadpool.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 查询线程池中线程的执行流程
 */
public class ThreadPoolTest  implements Runnable{
    public static void main(String[] args) {
        {
            LinkedBlockingQueue<Runnable> queue =
                    new LinkedBlockingQueue<Runnable>(5);
            ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                    5, 10, 60,
                    TimeUnit.SECONDS,
                    queue,
                    new ThreadPoolExecutor.CallerRunsPolicy());
            for (int i = 0; i < 20; i++)
            {
                threadPool.execute(
                        new Thread(new ThreadPoolTest(), "Thread".concat(i + "")));
                System.out.println("线程池中活跃的线程数： " + threadPool.getPoolSize());
                if (queue.size() > 0)
                {
                    System.out.println("----------------队列中阻塞的线程数" + queue.size());
                }
            }
            threadPool.shutdown();
        }
    }
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
