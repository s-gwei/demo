package com.sun.webSocket;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sungw
 * @version 1.0
 * @date 2021/8/3 11:05 上午
 */
public class Server {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        for(int i=0;i<10000;i++){
            list.add(i);
        }
        System.out.println("添加完毕");
    }

}

