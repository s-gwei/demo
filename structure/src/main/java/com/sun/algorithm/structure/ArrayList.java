package com.sun.algorithm.structure;

import java.util.LinkedList;

public class ArrayList {
    // Default initial capacity.默认初始容量,在第一次add元素是，给数组分配的长度
    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    // ArrayList最重要的两个元素，elementData和size
    transient Object[] elementData;// transient修饰是不被序列化，节省空间，

    //元素具体存储对象
    private Object[] oldList;

    //数组中元素个数
    private int size;

    public ArrayList(){
        this.oldList = null;
    }

    public void add(Object obj){

        if(size == 0){
            oldList = new Object[DEFAULT_CAPACITY];
        }
        if(size+1 > oldList.length){
            int length = oldList.length+oldList.length>>1;
            Object[] newList = new Object[length];
            for (int i=0;i<oldList.length;i++) {
                newList[i] = oldList[i];
            }
            oldList = newList;
        }
        oldList[size] = obj;
        size++;
    }

    //get方法,有可能数组下标越界异常
    public Object get(int index){
        return oldList[index];
    }

    //play展示数组中所有元素
    public void play(){
        for(int index = 0;index<oldList.length;index++ ){
            System.out.print(oldList[index]+"  ,");
        }
    }
}
