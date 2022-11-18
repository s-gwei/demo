package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 斐波那契数列
 * @date 2021/6/18
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。
 * 斐波那契数列的定义如下：
 */
public class S10_1 {


    int[] db;
    public int fib(int n) {
        //定义字典表
        db = new int[n+1];
        return  digui1(n);
    }

    private int digui1(int n) {
        if(n <=1){
            return n;
        }
        if(db[n] != 0){
            return db[n];
        }
        db[n] = (digui1(n-1)+digui1(n-2))%1000000007;
        return db[n];
    }

    private int digui2(int n) {
        if(n<=1){
            return n;
        }
        db[0] = 0;
        db[1] = 1;

        for(int i=2;i<=n;i++){
            db[i]=(db[i-1]+db[i-2])%1000000007;
        }
        return db[n];
    }
}
