package com.sun.link;

/**
 * 单链表实现
 */
public class Link {
    public static void main(String[] args) {
        Link link = new Link();


        System.out.println(link.containsNode("a"));
        link.play();
    }
    private Node head;    		//头结点
    private int size;			//链表元素个数
    //构造函数
    public Link(){
        this.head = null;
        this.size = 0;
    }
    //添加节点(头插法)
    public void addNodeHead(Object obj){
        //判断头节点是否为空
        Node temp = head;
        Node node = new Node(obj);
        if(temp == null){
            head = node;
        }else {
            node.next = temp;
            head = node;
        }
    }
    //添加节点（尾插法）
    public void addNode(Node node){
        //判断头节点是否为空
     Node temp = head;
      if(temp == null){
          head = node;
      }
      while(temp.next != null){
          temp = temp.next;
      }
      temp.next = node;
    }
    //判断节点是否存在
    public boolean containsNode(Object data){
        boolean flag =true ;
        Node temp = head;
        while(!data.equals(temp.data)){
            if(temp.next == null){
                flag = false;
                break;
            }
            temp = temp.next;
        }
        return flag;
    }
    //展示所有节点数据
    public void play(){
        Node temp = head;
        while(temp.next != null){
            System.out.println(temp.data.toString());
            temp = temp.next;
        }
        System.out.println(temp.data.toString());
    }

    //删除某个节点
//    public

}

