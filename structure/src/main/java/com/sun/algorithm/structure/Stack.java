package com.sun.algorithm.structure;

/**
 * @Author sungw
 * @Date 2023/2/2 13:13
 * 使用node节点实现栈,先进后出
 **/
public class Stack<E> {

    private E element;
    private NodeTwo<E> first;
    private NodeTwo<E> last;
    private int size;

    public void add(E element){
        NodeTwo<E> head = this.first;
        NodeTwo<E> node = new NodeTwo<>(element,null,null);
        if(head == null){
            this.first = node;
        }else {
            node.next = head;
            this.first = node;
        }
    }

    public NodeTwo remove(){
        NodeTwo node = this.first;
        this.first = node.next;
        return node;
    }
}
