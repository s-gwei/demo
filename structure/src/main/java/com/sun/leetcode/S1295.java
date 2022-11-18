package com.sun.leetcode;

/**
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 *
 * 输入：nums = [12,345,2,6,7896]
 * 输出：2
 * 解释：
 * 12 是 2 位数字（位数为偶数）
 * 345 是 3 位数字（位数为奇数）
 * 2 是 1 位数字（位数为奇数）
 * 6 是 1 位数字 位数为奇数）
 * 7896 是 4 位数字（位数为偶数）
 * 因此只有 12 和 7896 是位数为偶数的数字
 */
public class S1295 {
    public static void main(String[] args) {
        int[] a = {12,1,2,3,5,9};
        System.out.println(findNumbers(a));
    }
    public static int findNumbers(int[] nums) {
        int count = 0;
        for(int a : nums){
            if(a>0 && a<10){

                continue;
            }
            if(a/10 > 0 && a/10 <10){
                count++;
                continue;
            }
            if(a/100 > 0 && a/100 <10){
                continue;
            }
            if(a/1000 > 0 && a/1000 <10){
                count++;
                continue;
            }
            if(a/10000 > 0 && a/10000 <10){
                continue;
            }
            if(a/100000 > 0 && a/100000 <10){
                count++;
                continue;
            }

        }
          return count;
    }
}
