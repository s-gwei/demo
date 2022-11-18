package com.sun.array;

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

    //add方法
    public void add(Object obj){
        //判断是否是第一次添加元素
        if(oldList == null){
            oldList = new Object[DEFAULT_CAPACITY];
        }
        //判断是否需要扩容，扩容到原来的1.5倍
        if(size+1>oldList.length){
            // << 和>>是java中的移位运算符，<<是左移位，>>是右移位，因为数据存储是二进制的所以左移1相当于乘以2的1次方，
            // 右移相当于乘以2的-1次方，例如
            int newLength = oldList.length + (oldList.length >> 1);
            Object[] newList = new Object[newLength];
            for(int i=0;i<oldList.length;i++){
                newList[i] = oldList[i];
            }
            newList[size] = obj;
            oldList = newList;
            int a = 1;
        }
        //不需要扩容时，直接加到数组中
        else{
            oldList[size]=obj;
        }
        size++;
    }
    //get方法,有可能数组下标越界异常
    public Object get(int index){
        return oldList[index];
    }

    //remove方法
    public Boolean remove(Object obj){
        boolean flag =false;
        if(obj == null){
            for(int i=0;i<oldList.length;i++){
                if(oldList[i] == obj ){
                    oldList[i] = null;
                    size--;
                    flag = true;
                }
            }
            return flag;
        }
        for(int i=0;i<oldList.length;i++){
            if(obj.equals(oldList[i])){
                oldList[i] = null;
                size--;
                flag = true;
            }
        }
        return flag;
    }

    //play展示数组中所有元素
    public void play(){
        for(int index = 0;index<oldList.length;index++ ){
            System.out.print(oldList[index]+"  ,");
        }
    }


}
