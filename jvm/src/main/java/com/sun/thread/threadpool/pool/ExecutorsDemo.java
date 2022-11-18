package com.sun.thread.threadpool.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 线程池的使用demo
 *
 * corePoolSize：线程池核心线程数量
 * maximumPoolSize:线程池最大线程数量
 * keepAliverTime：当活跃线程数大于核心线程数时，空闲的多余线程最大存活时间
 * unit：存活时间的单位
 * workQueue：存放任务的队列
 * handler：超出线程范围和队列容量的任务的处理程序
 *
 * 四种拒绝策略
 * 1、AbortPolicy策略：该策略会直接抛出异常，阻止系统正常工作；
 *
 * 2、CallerRunsPolicy策略：如果线程池的线程数量达到上限，
 * 该策略会把任务队列中的任务放在调用者线程当中运行；
 * 不再向下执行main方法中的es.execute(t7)这段代码。也就是说，
 * 在本程序中最多会有3个任务在执行，3个在等待。
 * 由此限制了线程池的等待任务数与执行线程数。
 * 所以JDK文档才会说：“这提供了一个简单的反馈控制机制，将降低新任务提交的速度”。
 *
 * 3、DiscardOledestPolicy策略：该策略会丢弃任务队列中最老的一个任务，
 * 也就是当前任务队列中最先被添加进去的，马上要被执行的那个任务，并尝试再次提交；
 *
 * 4、DiscardPolicy策略：该策略会默默丢弃无法处理的任务，不予任何处理。
 * 当然使用此策略，业务场景中需允许任务的丢失；
 *
 *
 */
public class ExecutorsDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                2,
                0,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(512), // 使用有界队列，避免OOM
                new ThreadPoolExecutor.CallerRunsPolicy());

        List<Future<List>> futures = new ArrayList<>();
        for (int i=0;i<10000;i++) {
            /**
             * 原因：内部类中使用但未声明的任何局部变量必须在内部类的正文之前明确分配。
             * 解决办法：在for循环内，将i的值重新赋值给另外一个变量 int j = i;
             */
            int j=i;
            Future<List> submit = executorService.submit(new Callable<List>() {
                @Override
                public List call() throws Exception {
                    return redisGet(j);
                }
            });
            futures.add(submit);
        }
        List list = new ArrayList<>();
        for(Future future : futures){
            Object obj = null;
            try {
               obj =  future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                if(obj != null){
                    list.add(obj);
                }
            }
        }
    }

    private static List redisGet(int i) {
        List sum = new ArrayList();
        for(int j = 0;j<i;j++){
            sum.add(j);
        }
        return sum;
    }


}
