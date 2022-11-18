package com.sun.thread.juc;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CopyOnWriteArrayList {
}

class HelloDemo implements Runnable{

    public static List<String> list = new ArrayList();
    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }

    @Override
    public void run() {
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            list.add("AA");
        }
    }
}