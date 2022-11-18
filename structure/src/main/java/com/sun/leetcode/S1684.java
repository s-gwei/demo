package com.sun.leetcode;

/**
 *
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 *
 * 请你返回 words 数组中 一致字符串 的数目。
 *
 *输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 *
 */
public class S1684 {
    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = {"ad","bd","aaab","baa","badab"};
        int a =countConsistentStrings(allowed,words);
        System.out.println(a);
    }


    public static int countConsistentStrings(String allowed, String[] words) {
         String[] alloweds = allowed.split("");
         int i = 0;
         for(String str:words){
             String[] strs = str.split("");
             boolean flag = true;
             for(String a :strs){
                 if(!allowed.contains(a)){
                     flag = false;
                     break;
                 }
             }
             if(flag){
                 i++;
             }
         }
         return i;
    }
}
