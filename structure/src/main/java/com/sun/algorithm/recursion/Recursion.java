package com.sun.algorithm.recursion;

/**
 * @description: 递归算法核心
 * 一，算法用来做什么事
 * 二，结束递归的条件
 * 三，找出函数的等价关系式
 * @author: sungw
 * @create: 2022-12-07 17:19
 **/
public class Recursion {
    public static void main(String[] args) {
        System.out.println(new Recursion().recursion(6));
    }

    /**
     *斐波那契数列的是这样一个数列：1、1、2、3、5、8、13、21、34….，
     * 即第一项 f(1) = 1,第二项 f(2) = 1…..,
     * 第 n 项目为 f(n) = f(n-1) + f(n-2)。求第 n 项的值是多少。
     * @param n
     * @return
     */
    public int recursion(int n){
        if(n<=2){
            return 1;
        }
        return recursion(n-1)+recursion(n-2);
    }


}
