package com.sun.link;

/**
 * 栈：先进后出
 */
public class Stack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        System.out.println(stack.getSize());
        System.out.println(stack.remove1(4));
        stack.play();
    }
    Node head;//头节点
    int size; //栈中元素个数
    //添加元素
    public void add(Object data){
        Node node = new Node(data);
        //判断头节点是否为空
        Node temp = head;
        if(temp == null){
            head = node;
        }
            node.next = temp;
            head = node;
        size++;
    }
    //出栈，先进后出
    public Object removeOne(){
        Object obj = null;
        //判断头节点是否为空
        Node temp = head;
        if(temp == null){
            return  obj;
        }
        obj = head.data;
        head = temp.next;
        size--;
        return  obj;
    }
    //打印栈中元素,使用while循环，不用递归
    public void play(){
        Node temp = head;
        if(temp == null){
            return;
        }
        String str = temp.data.toString()+";";
        while(temp.next != null){
            temp = temp.next;
            str += temp.data.toString()+";";
        }
        System.out.println(str);
    }
    //获取栈中元素个数
    public int getSize(){
        return size;
    }

    //删除某个元素
    public boolean remove(Object data){
        //判断头节点是否为空
        Node temp = head;
        if(temp == null){
            return false;
        }
        //判断元素是否为头节点
        if(temp.data.equals(data)){
            head = temp.next;
            size--;
            return true;
        }
        Node current = temp;
        Node previse = temp;

        while(!current.data.equals(data)){
            previse = current;
            current = current.next;
            if (current.next == null){
                return false;
            }
        }
        previse.next = current.next;
        size--;
        return true;

    }

    //删除某个元素,删除某个元素只需要知道它的上一个元素是什么就足够了
    public boolean remove1(Object data){
        //判断头节点是否为空
        Node temp = head;
        if(temp == null){
            return false;
        }
        //判断元素是否为头节点
        if(temp.data.equals(data)){
            head = temp.next;
            size--;
            return true;
        }
        if(temp.next == null){
            return false;
        }
        while(!temp.next.data.equals(data)){
            temp.next = temp.next.next;
            if(temp.next == null){
                return false;
            }
        }
        temp.next = temp.next.next;
        size--;
        return true;

    }
}


