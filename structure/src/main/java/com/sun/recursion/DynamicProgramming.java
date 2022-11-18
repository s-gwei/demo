package com.sun.recursion;

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
 *
 */
public class DynamicProgramming {

    public static void main(String[] args) {
        int a = fib1(10);
//        int a = fib(10);
        System.out.println(a);
    }

    //暴力递归
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     *     带备忘录的递归算法，自顶向上
     *     递归算法时间复杂度：递归函数调用次数*递归函数本身的复杂度
     */


    public static int fib1(int n) {
        int[] memo = new int[n + 1];
        int result = helper(memo, n);
        for (int a : memo) {
            System.out.println(a);
        }
        return result;
    }

    private static int helper(int[] memo, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    //使用dp数组,自底向上

    private static int helper(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
