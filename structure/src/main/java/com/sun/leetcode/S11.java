package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 盛最多水的容器
 * @date 2021/5/20
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai)
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]
 * 在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */
public class S11 {
    public static void main(String[] args) {
//        int[] a = {1,8,6,2,5,4,8,3,7};
//        int[] a = {0,0,2,3,0};
        int[] a = {4,3,2,1,4};
        System.out.println(maxArea(a));
    }
    public static int maxArea(int[] height) {
        int room = 0;
        int max = 0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                room = (j-i)*(height[j] > height[i] ? height[i] : height[j]);
                if(room>max){
                    max=room;
                }
            }
        }
        return max;
    }
}
