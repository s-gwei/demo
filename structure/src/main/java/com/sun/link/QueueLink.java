package com.sun.link;

/**
 * author sungw
 *
 * @description 链表实现队列
 * @date 2021/5/11
 */
public class QueueLink {
    public static void main(String[] args) {
        QueueLink queueLink = new QueueLink();
        queueLink.add(1);
        queueLink.add(2);
//        queueLink.add(3);
//        queueLink.add(4);
        queueLink.remove();
        queueLink.play();
    }
    Node head;//头节点
    int size;
    Node tail;//尾节点

    /**
     * 添加元素
     */
    public void add(Object data){
        //判断头尾节点是否为null
        if(head == null && tail == null){
            Node node = new Node(data);
            head=node;
            tail=node;
            size++;
            return;
        }
        Node node = new Node(data);
        Node temp = head;
        head = node;
        head.next = temp;
        size++;
    }
    //先进先出
    public boolean remove(){
        if(head == null || tail == null){
            return  false;
        }
        Node temp = head;
        if(tail == head ){
            head =null;
            tail = null;
            size--;
            return true;
        }
        while(temp != null){
            if(temp.next == tail){
                temp.next=null;
                tail=temp;
                size--;
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    //打印队列中所有元素
    public  void play(){
        Node temp = head;
        if(temp == null){
            return;
        }
        String str = "";

        while(temp != null){
            str +=temp.data.toString()+";";
            temp = temp.next;
        }
        System.out.println(str);
    }
}
