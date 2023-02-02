package com.sun.algorithm.structure;

/**
 * @Author sungw
 * @Date 2023/2/2 14:26
 **/
public class Node {
    private Object data;
    public Node next;

    public Node(Object data, Node next){
        this.data = data;
        this.next = next;
    }
}
