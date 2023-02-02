package com.sun.algorithm.structure;

/**
 * @Author sungw
 * @Date 2023/2/2 14:27
 * 单向节点实现队列，先进先出
 **/
public class Queue {

    private Node head;
    private int size;

    public void add(Object obj){
        Node node = new Node(obj,null);
        if(head == null){
            head = node;
        }else{
            node.next = head;
            head = node;
        }
        size++;
    }

    public Node remove(){
        Node node = head;
        Node current = head.next;
        Node previce = head;
        while(current != null){
            if(current.next == null){
                previce.next = null;
                size--;
                return current;
            }
            previce = previce.next;
            current = previce.next;
        }
        return null;
    }
}
