package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 回文数
 * @date 2021/5/12
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *输入：x = 121
 * 输出：true
 */
public class S9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
    }

    public static boolean isPalindrome(int x) {
         String str = String.valueOf(x);
         String[] s = str.split("");
         if("-".equals(s[0])){
             return false;
         }
         int a = s.length%2;
         if(a == 0){
             for(int i=0;i<(s.length/2);i++){
                 if(!s[i].equals(s[s.length-1-i])){
                     return false;
                 }
             }
         }else{
             for(int i=0;i<((s.length-1)/2);i++){
                 if(!s[i].equals(s[s.length-1-i])){
                     return false;
                 }
             }
         }

         return  true;
    }
}
