package com.sun.string;

public class StringTest03 {
    public static void main(String[] args) {
        String s = new String("1");
        String s1 =  s.intern();//调用此方法之前，字符串常量池中已经存在了"1"
        String s2 = "1";
        String s3 =  new String("1");
        String s4 = s3.intern();
        System.out.println(s1 == s2);//jdk6：false   jdk7/8：true
        System.out.println(s3 == s);//jdk6：false   jdk7/8：true
        System.out.println(s1==s4);
    }
}
