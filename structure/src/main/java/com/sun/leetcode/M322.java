package com.sun.leetcode;

import java.util.Arrays;

/**
 * author sungw
 *
 * @description 零钱兑换
 * @date 2021/6/4
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 */
public class M322 {
    //暴力递归写法
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount <= 0) return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            //计算子问题结果
            int subProblem = coinChange(coins, amount - coin);
            //子问题无解则跳过
            if (subProblem == -1) continue;
            //在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    int[] memo;

    //字典表写法
    public int coinChange1(int[] coins, int amount) {
        memo = new int[amount + 1];
        //给字典数组一个不会出现的值，用来判断是否重复计算
        Arrays.fill(memo, -11);

        return db(coins, amount);
    }

    private int db(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        //查看备忘录，防止重复计算
        if (memo[amount] != -11)
            return memo[amount];
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            //计算子问题的结果
            int subProblem = db(coins, amount - coin);
            //子问题无解，则跳过
            if (subProblem == -1) continue;
            //在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }
        //把计算结果存入备忘录
        memo[amount] = (res == Integer.MAX_VALUE ? -1 : res);
        return memo[amount];
    }

    private int dp(int[] coins ,int amount){
        if(amount == 0)return 0;
        if(amount < 0)return -1;
        //查看dp数组是否存在amount
        if(memo[amount]  != -11){
            return memo[amount];
        }
        //用来记录使用硬币最少
        int res = Integer.MAX_VALUE;
        for(int coin : coins){
            //计算子问题结果
            int sub = dp(coins,amount - coin);
            if(sub == -1)
                continue;
            res = Math.min(res,sub+1);
        }
        memo[amount] = (res == Integer.MAX_VALUE ? -1 :res);
        return memo[amount];
    }


}
