package com.sun.concurrent.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * author sungw
 *
 * @description AQS源码解析
 * @date 2021/5/19
 */
public class AQS {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        System.out.println(1);
        lock.unlock();
    }
    public Node tail;

    public int state;

    public Node head;

    /**
     * 独占式获取同步状态
     */
    public final void acquire(int arg) {
        if (!tryAcquire(arg) && acquireQueued(addWaiter(Node.EXCLUSIVE), arg)) {
            selfInterrupt();
        }
    }
    /**
     * 尝试去获取锁，获取成功返回true，否则返回false。该方法由继承AQS的子类自己实现。
     * 采用了模板方法设计模式。
     * 如：ReentrantLock的Sync内部类，Sync的子类：NonfairSync和
     * @param arg
     * @return
     * tryAcquire在ReentrantLock实现，判断state是否为0，
     * 如果为0，将当前线程添加到队列中，head=当前线程，使用CAS操作将state变为1，
     * 不为0，则无法获取锁
     *
     */
    protected boolean tryAcquire(int arg) {
        final Thread current = Thread.currentThread();
        int c = state;
        if (c == 0) {
//            if (!hasQueuedPredecessors() &&
//                    compareAndSetState(0, acquires)) {
//                setExclusiveOwnerThread(current);
//                return true;
//            }
        }
//        else if (current == getExclusiveOwnerThread()) {
//            int nextc = c + acquires;
//            if (nextc < 0)
//                throw new Error("Maximum lock count exceeded");
//            setState(nextc);
//            return true;
//        }
        return false;

    }

    /**
     * 获取到锁的线程，将本线程加到head
     * @return
     */
    public final boolean hasQueuedPredecessors() {
        // The correctness of this depends on head being initialized
        // before tail and on head.next being accurate if the current
        // thread is first in queue.
        Node t = tail; // Read fields in reverse initialization order
        Node h = head;
        Node s;
        return h != t &&
                ((s = h.next) == null || s.thread != Thread.currentThread());
    }
    private void selfInterrupt() {
    }



    /**
     * 加入等待队列中去
     * @param mode
     * @return
     */
    private Node addWaiter(Node mode) {
        // 新建Node节点
        Node node = new Node(Thread.currentThread(), mode);
        // 尝试快速添加尾结点
        Node pred = tail;
        if (pred != null) {
            node.prev = pred;
            // CAS方式设置尾结点
            if (compareAndSetTail(pred, node)) {
                pred.next = node;
                return node;
            }
        }
        // 如果上面添加失败，这里循环尝试添加，直到添加成功为止
        enq(node);
        return node;
    }

    /**
     * 将等待节点加到同步队列中，
     * 直接将node加到队尾tail
     * 如果node的前置节点是head，则将node自旋，尝试获取锁，如果获取锁成功，
     * 将head节点移除队列，则node变为head节点，
     * 如果node的前置节点不是head，则将node阻塞，放弃cpu资源。
     *
     *
     *
     * @param node
     * @param arg
     * @return
     */
    final boolean acquireQueued(final Node node, int arg) {
        // 操作是否成功标志
        boolean failed = true;
        try {
            // 线程中断标志
            boolean interrupted = false;
            // 不断的自旋循环
            for (;;) {
                // 当前节点的prev节点
                final Node p = node.predecessor();
                // 判断prev是否是头结点 && 是否获取到同步状态
                if (p == head && tryAcquire(arg)) {
                    // 以上条件成立，将当前节点设置成头结点
                    setHead(node);
                    // 将prev节点移除队列中
                    p.next = null; // help GC
                    failed = false;
                    return interrupted;
                }
                // 自旋过程中，判断当前线程是否需要阻塞 && 阻塞当前线程并且检验线程中断状态
                if (shouldParkAfterFailedAcquire(p, node) &&
                        parkAndCheckInterrupt())
                    interrupted = true;
            }
        } finally {
            if (failed)
                // 取消获取同步状态
                cancelAcquire(node);
        }
    }
    /**
     * 比较节点的前置节点是否为头节点
     * @param pred
     * @param node
     * @return
     */
    private boolean compareAndSetTail(Node pred, Node node) {
        return true;
    }


    /**
     * 设置阻塞
     * @return
     */
    private boolean parkAndCheckInterrupt() {
        return true;
    }

    /**
     * 自旋过程中，判断当前线程是否需要阻塞 && 阻塞当前线程并且检验线程中断状态
     * @param p
     * @param node
     * @return
     */
    private boolean shouldParkAfterFailedAcquire(Node p, Node node) {
        return true;
    }

    /**
     * 取消同步状态
     * @param node
     */
    private void cancelAcquire(Node node) {
    }

    /**
     * 设置节点为头节点
     * @param node
     */
    private void setHead(Node node) {
        head = node;
        node.thread = null;
        node.prev = null;
    }

    private Node enq(final Node node) {
        // 一直for循环，直到插入Node成功为止
        for (;;) {
            Node t = tail;
            if (t == null) {
                // CAS设置首节点
                if (compareAndSetHead(new Node()))
                    tail = head;
            } else {
                node.prev = t;
                // CAS设置尾结点
                if (compareAndSetTail(t, node)) {
                    t.next = node;
                    return t;
                }
            }
        }
    }

    /**
     * CAS比较并设置头节点
     * @param node
     * @return
     */
    private boolean compareAndSetHead(Node node) {
        return true;
    }








    /**
     *    释放独占式同步状态
     *
     */

    public final boolean release(int arg) {
        if (tryRelease(arg)) {
            Node h = head;
            if (h != null && h.waitStatus != 0)
                // 如果头结点不为空 && 并且 头结点状态不为0
                // 唤醒头结点的后继节点
                unparkSuccessor(h);
            return true;
        }
        return false;
    }

    /**
     *
     * tryRelease
     * 尝试去释放同步状态，释放成功返回true，否则返回false。
     * 该方法由继承AQS的子类自己实现。采用了模板方法设计模式。
     * 如：ReentrantLock的Sync内部类的tryRelease方法。
     * @param arg
     * @return
     */

    protected boolean tryRelease(int arg) {
//        int c = getState() - releases;
//        if (Thread.currentThread() != getExclusiveOwnerThread())
//            throw new IllegalMonitorStateException();
//        boolean free = false;
//        if (c == 0) {
//            free = true;
//            setExclusiveOwnerThread(null);
//        }
//        setState(c);
//        return free;
        return false;
    }

    /**
     * 唤醒阻塞线程
     * @param node
     */
    private void unparkSuccessor(Node node) {
        /*
         * 获取当前节点状态
         */
        int ws = node.waitStatus;

        // 如果当前节点的状态小于0，那么用CAS设置成0
        if (ws < 0){

        }
//            compareAndSetWaitStatus(node, ws, 0);

        /*
         * 获取当前节点的后继节点
         */
//        Node s = node.next;
//            Node s = new Node();
        // 如果后继节点为空 || 或者后继节点的状态 > 0 (为取消状态)
//        if (s == null || s.waitStatus > 0) {
//            s = null;
//            // 从尾结点查找状态不为取消的可用节点
//            for (Node t = tail; t != null && t != node; t = t.prev)
//                if (t.waitStatus <= 0)
//                    s = t;
//        }
//        if (s != null)
//            // 唤醒后继节点
//            LockSupport.unpark(s.thread);
    }
}
