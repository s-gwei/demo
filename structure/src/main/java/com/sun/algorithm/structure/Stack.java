package com.sun.algorithm.structure;

/**
 * @Author sungw
 * @Date 2023/2/2 13:13
 * 使用node节点实现栈,先进后出
 **/
public class Stack<E> {

    private Node head;
    private int size;

    public void add(E element){
        Node node = this.head;
        Node newNode = new Node(element,null);
        if(node == null){
            this.head = node;
        }else {
            node.next = head;
            this.head = newNode;
        }
    }

    public Node remove(){
        Node node = this.head;
        this.head = node.next;
        return node;
    }
}
