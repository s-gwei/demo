package com.sun.algorithm.structure;

/**
 * @Author sungw
 * @Date 2023/2/2 12:13
 * 双向链表的单节点
 **/
public class NodeTwo<E> {
    E item;
    NodeTwo<E> next;
    NodeTwo<E> prev;

    public NodeTwo(E item, NodeTwo<E> next, NodeTwo<E> prev) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }
}
