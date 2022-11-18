package com.sun.thread.juc;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
//        ConcurrentHashMap map = new ConcurrentHashMap(4);
//        for(int i=0;i<10000;i++){
//            map.put(i,i);
//        }
        HashMap map1 = new HashMap(1111);
        map1.put("1",1);

    }

/*    void transfer(Map.Entry[] newTable, boolean rehash) {
        int newCapacity = newTable.length;
        for (Entry<K,V> e : table) {
        //判断数组节点是否为空
            while(null != e) {
            //获取e的next节点，单独保存
                Entry<K,V> next = e.next;
                if (rehash) {
                    e.hash = null == e.key ? 0 : hash(e.key);
                }
                int i = indexFor(e.hash, newCapacity);
                将e节点的下个节点置为null,也就是将e置为单个节点，没有子节点
                e.next = newTable[i];
                newTable[i] = e;//线程在此时停下
                将next节点变为e
                e = next;
            }
        }

    }*/

}
