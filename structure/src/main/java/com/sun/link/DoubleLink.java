package com.sun.link;

/**
 * author sungw
 *
 * @description 双向链表
 * @date 2021/5/11
 */
public class DoubleLink {
    public static void main(String[] args) {
        DoubleLink doubleNode = new DoubleLink();
        doubleNode.add("1");
        doubleNode.add("2");
        doubleNode.add(3);
        doubleNode.add(4);
        doubleNode.add(5);
        doubleNode.add(6);
        doubleNode.remove("1");
        doubleNode.play();
    }

    DoubleNode head;
    int size;

    //添加元素
    public void add(Object data){
        if(head == null){
            DoubleNode node = new DoubleNode(data);
            head = node;
            size++;
            return;
        }
        DoubleNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        DoubleNode node = new DoubleNode(data);
        node.pre = temp;
        temp.next = node;
        size++;
    }
    //删除元素
    public  boolean remove(Object data){
        if(head == null){
            return false;
        }
        DoubleNode temp = head;
        if(head.data.equals(data.toString())){
            temp = temp.next;
            temp.pre = null;
            head = temp;
            size--;
            return true;

        }

        while(temp.next != null){
            if(temp.next.data.equals(data.toString())){
                temp.next = temp.next.next;
                temp.next.next.pre = temp.next;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    //展示所有节点数据
    public void play(){
        DoubleNode temp = head;
        while(temp.next != null){
            System.out.println(temp.data.toString());
            temp = temp.next;
        }
        System.out.println(temp.data.toString());
    }


}
