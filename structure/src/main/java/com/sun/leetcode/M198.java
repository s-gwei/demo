package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 打家劫舍
 * @date 2021/6/23
 * 动态规划问题
 */
public class M198 {
    public int rob(int[] nums) {

        //创建字典表
        int[] dp = new int[nums.length];

        if(nums == null){
            return 0;
        }
        if(nums.length == 1){
            return nums[1];
        }
        //初始化dp
        dp[0] = nums[0];
        //状态转移方程
        dp[1] = Math.max(dp[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            dp[2] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];

    }
}
