package com.sun.leetcode;

/**
 *
 *给你两个整数，n 和 start 。
 *
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 *
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 *
 *输入：n = 5, start = 0
 * 输出：8
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 *      "^" 为按位异或 XOR 运算符。
 *
 *
 *
 */
public class S1486 {
    public static void main(String[] args) {
        xorOperation(5,0);
    }
    public static int xorOperation(int n, int start) {
        int sum = start;
        for(int i=1;i<n;i++){
            int a = start + 2*i;
            //异或运算符
            sum = sum^a;
        }
        System.out.println(sum);
        return sum;
    }
}
