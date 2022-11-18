package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 3. 无重复字符的最长子串
 * @date 2021/5/20
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class S3 {
    public static void main(String[] args) {
        String s = "  ";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if("".equals(s)){
            return 0;
        }
        String[] a = s.split("");
        int temp = 0;
        int max = 1;
        String s1="";
        for(int i=0;i<a.length;i++){
            if(!s1.contains(a[i])){
                s1 +=a[i];
                temp++;
                continue;
            }
            s1=a[i];
            if(temp>max){
                max=temp;
                temp=1;
            }
        }
        if(temp>max){
            max=temp;
        }
        return max;
    }
}
