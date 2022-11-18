package com.sun.link;

/**
 * 队列：先进先出
 */
public class Queue {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.remove();
        queue.play();
    }
    Node head;
    int size;

    //添加元素，头插法
    public void add(Object data){
        Node node = new Node(data);
        //判断head是否为null
         Node temp = head;
         if(temp == null){
             head = node;
             size++;
             return;
         }
         head = node;
         node.next = temp;
         size++;

    }
    //出队，先进先出
    public boolean remove(){
        //判断head是否为null
        Node temp = head;
        if(temp == null){
            return  false;
        }
        Node current = temp.next;
        Node previce = temp;
       while(current != null){
           if(current.next ==null){
               previce.next = null;
               size--;
               return true;
           }
           previce = previce.next;
           current = previce.next;
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
