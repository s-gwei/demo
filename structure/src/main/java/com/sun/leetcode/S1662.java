package com.sun.leetcode;

/**
 *
 * 1662. 检查两个字符串数组是否相等
 *给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 *
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 *
 *
 *
 */
public class S1662 {
    public static void main(String[] args) {
        String[] a = {"a","bc"};
        String[] b = {"a","bc"};
        arrayStringsAreEqual(a,b);
    }
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        boolean flag = false;
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for(int i = 0 ;i<word1.length;i++){
            sb1.append(word1[i]);
        }
        for(int i = 0 ;i<word2.length;i++){
            sb2.append(word2[i]);
        }
        if(sb1.toString().equals(sb2.toString())){
            flag = true;
        }
         return flag;
    }
}
