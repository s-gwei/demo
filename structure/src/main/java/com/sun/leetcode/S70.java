package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 动态规划问题
 * @date 2021/6/11
 *
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class S70 {
    public static void main(String[] args) {
        climbStairs(3);
    }
    public static int climbStairs(int n) {
        //定义字典数组
        int[] db = new int[n+1];

        int result = dy(db,n);

        return result;
    }

    private static int dy(int[] db, int n) {
        //如果n=1或n=1跳出递归
        if(n==0||n==1){
            return 1;
        }
        //如果字典数组中有db[n],直接返回
        if(db[n] != 0){
            return db[n];
        }
        db[n] = dy(db,n-1)+dy(db,n-2);
        return db[n];
    }
}
