package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 动态规划问题
 * @date 2021/6/11
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），
 * 如计算初始结果为：1000000008，请返回 1。
 */
public class S10 {
    public static void main(String[] args) {
        numWays(2);

    }

    public static int numWays(int n) {
        //定义字典数组
        int[] db = new int[n + 1];

//        int result = Dy(db, n);

        int result = Dy1(db, n);

        return result;
    }

    private static int Dy1(int[] db, int n) {
        //给与终止递归条件
        db[0]=1;

        db[1]=1;

        //状态转换
        for(int i=2;i<=n;i++){
            db[n] = (db[n-1]+db[n-2])%1000000007;
        }
//        db[n] = (Dy(db,n-1)+Dy(db,n-2))/1000000007;
        return db[n];
    }
    private static int Dy(int[] db, int n) {
        //给与终止递归条件
        if (n == 0 || n == 1 ) {
            return 1;
        }
        //如果字典数组中已有，则不在递归
        if (db[n] != 0) {
            return db[n];
        }
        //状态转换
        for(int i=2;i<=n;i++){
            db[n] = (db[n-1]+db[n-2])/1000000007;
        }
//        db[n] = (Dy(db,n-1)+Dy(db,n-2))/1000000007;
        return db[n];
    }
}
