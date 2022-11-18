package com.sun.leetcode;

public class S7 {
    public static void main(String[] args) {
        System.out.println(reverse(-123));

    }

    public static  int reverse(int x) {
        String s="";
        if(x<0){
            s="-";
            x = -x;
        }if(x==0){
            return 0;
        }
        Integer a = x;
        String[] str = a.toString().split("");

        for(int i=str.length;i>0;i--){
            if(i==str.length&&("0".equals(str[i-1]))){
                continue;
            }
            s+=str[i-1];
        }
        return Integer.parseInt(s);
    }
}
