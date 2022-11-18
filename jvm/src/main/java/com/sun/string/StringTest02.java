package com.sun.string;

/**
 *  对象1：new StringBuilder(ab)
 *  对象2： new String("a")
 *  对象3： 常量池中的"a"
 *  对象4： new String("b")
 *  对象5： 常量池中的"b"
 *此时常量池中并没有”ab“这个对象
 *
 */
public class StringTest02 {
    public static void main(String[] args) {
//        String a = new String("a")+new String("b");
        String b = "a"+"b";

        String c = "ab";
        System.out.println(b==c);
    }
}
