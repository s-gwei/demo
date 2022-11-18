package com.sun.link;

/**
 * author sungw
 *
 * @description 双向链表节点
 * @date 2021/5/11
 */
public class DoubleNode {
    Object data;//节点值
    DoubleNode pre;//前置节点
    DoubleNode next;//后置节点

    public DoubleNode(Object data){
        this.data = data;
    }
}
