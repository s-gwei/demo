package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 亲密字符串
 * @date 2021/6/11
 *给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 *
 * 交换字母的定义是取两个下标 i 和 j （下标从 0 开始），只要 i!=j 就交换 A[i] 和 A[j] 处的字符。例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 *
 *
 */
public class S859 {
    public boolean buddyStrings(String s, String goal) {
        String[] str = s.split("");
        for(String s1 : str){
            if(goal.contains(s1)){

            }
        }
        return false;
    }
}
