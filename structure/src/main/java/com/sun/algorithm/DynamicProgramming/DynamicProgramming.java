package com.sun.algorithm.DynamicProgramming;

import org.junit.Test;

/**
 * author sungw
 *
 * @description 动态规划
 * @date 2021/6/2
 *
 *
 *最优子问题：A到C的最优解中的B到C的那一段也一定是B到C的最优解
 *状态转换：A到B的问题和B到C的问题无耦合，可以分别单独求解
 *重叠子问题：A到B和B到C的问题属于一类问题，可以用同一套公式写出
 *
 * 动态规划求最值
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级，
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法？
 *
 *
 * 刚开始看到这个题目的时候可能没什么思路，不过我们可以一点点的想下去，
 * 我们假设青蛙跳上一个 n 级的台阶总共有多少种跳法 f(n) 种跳法，
 * 那当 n = 0 时，f(0) = 0，没有台阶当然没有跳法。
 * n = 1，f(1) = 1；只有一个台阶的时候，只能跳 1 个；
 * n = 2，f(2) = 2，当有两个台阶的时候，可以有 2 种跳法，一个一个跳和一下跳 2 个，
 * 那如果我们有三个台阶的话，是不是将一个台阶和两个台阶的总和加起来就可以了呢？
 * 所以我们就可以想到 f(3) = f(2) + f(1)，
 * 所以我们能推导出 f(n) = f(n - 1) + f(n - 2);
 */
public class DynamicProgramming {
    @Test
    public void test(){
//        System.out.println(digui(10));
        System.out.println(dp(10));
    }


    /**
     * 使用递归自顶向上求解
     * @param n
     * @return
     */
    public int digui(int n){
        if(n <= 2){
            return n;
        }
        return digui(n-1)+digui(n-2);
    }

    /**
     * 使用字典表，从下向上求解
     * @param n
     * @return
     */
    public int dp(int n) {
        if (n <= 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        // 之所以要从 3 开始，是因为 2 不符合下面的规则
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
