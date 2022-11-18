package com.sun.string;

/**
 * new String("a")创建了两个对象，堆中一个对象，常量池中一个对象
 */
public class StringTest01 {
    public static void main(String[] args) {
        String a= new String("a");
//        String a = "1";
        String b = a.intern();
        String c = "a";
        System.out.println(a==b);

    }
}
