package com.sun.recursion;

/**
 * author sungw
 *
 * @description 01背包问题
 * @date 2021/6/20
 * 货物数量只能是0，1，背包容量也是固定的x,
 */
public class Knapsack {

    public int knapsack(int W,int N,int[] Wt,int[] val){
        //初始化数组
        int[][] dp = new int[N+1][W+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=W;j++){
                if(W - Wt[i-1]<0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    //装入或者不装入背包择优
                    dp[i][j] = Math.max(
                            //把第i个装入背包
                            dp[i-1][W-Wt[i-1]]+val[i-1],
                            //不把第i个装入背包
                            dp[i-1][j]
                    );
                }
            }
        }
        return dp[N][W];

    }
}
