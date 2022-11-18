package com.sun.concurrent.aqs;

/**
 * author sungw
 *
 * @description AQS双向链表节点
 * @date 2021/5/19
 */
public class Node {
        /** 共享节点 */
        static final Node SHARED = new Node();

        /** 独占节点 */
        static final Node EXCLUSIVE = null;

        /** 因为超时或者中断，节点会被设置成取消状态，被取消的节点不会参与到竞争中，会一直是取消
         状态不会改变 */
        static final int CANCELLED =  1;

        /** 后继节点处于等待状态，如果当前节点释放了同步状态或者被取消，会通知后继节点，使其得以
         运行 */
        static final int SIGNAL    = -1;

        /** 节点在等待条件队列中，节点线程等待在condition上，当其他线程对condition调用了signal
         后，该节点将会从等待队列中进入同步队列中，获取同步状态 */
        static final int CONDITION = -2;

        /**
         * 下一次共享式同步状态获取会无条件的传播下去
         */
        static final int PROPAGATE = -3;

        /** 等待状态 */
        volatile int waitStatus;

        /** 前驱节点 */
        volatile Node prev;

        /** 后继节点 */
        volatile Node next;

        /** 获取同步状态的线程 */
        volatile Thread thread;

        /**
         * 下一个条件队列等待节点
         */
        Node nextWaiter;

        final boolean isShared() {
            return nextWaiter == SHARED;
        }

        final Node predecessor() throws NullPointerException {
            Node p = prev;
            if (p == null)
                throw new NullPointerException();
            else
                return p;
        }

        Node() {    // Used to establish initial head or SHARED marker
        }

        Node(Thread thread, Node mode) {     // Used by addWaiter
            this.nextWaiter = mode;
            this.thread = thread;
        }

        Node(Thread thread, int waitStatus) { // Used by Condition
            this.waitStatus = waitStatus;
            this.thread = thread;
        }

}
