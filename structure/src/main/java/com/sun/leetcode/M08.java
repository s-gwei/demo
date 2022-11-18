package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 动态规划问题
 * @date 2021/6/11
 * 硬币。给定数量不限的硬币，
 * 币值为25分、10分、5分和1分，
 * 编写代码计算n分有几种表示法。
 * (结果可能会很大，你需要将结果模上1000000007)
 */
public class M08 {


    private static final int mod = 1000000007;
    private static final int[] coins = {25, 10, 5, 1};

    public static void main(String[] args) {
        waysToChange(10);
    }

    public static int waysToChange(int n) {
        int[] db = new int[n + 1];
        int a = 10;
        for(int i = 0;i<100;i++){
            System.out.println("输出值为："+i);
        }
        db[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                db[i] = (db[i] + db[i - coin]) % mod;
            }
        }

        return db[n];

    }


}
