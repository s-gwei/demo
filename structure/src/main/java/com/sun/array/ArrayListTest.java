package com.sun.array;



public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for(int i=0;i<100;i++){
            list.add(i);
        }
//        list.remove("1");
        list.play();
    }
}
