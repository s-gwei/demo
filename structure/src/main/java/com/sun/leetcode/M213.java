package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 打家劫舍2.0
 * @date 2021/6/23
 * 将环形数组拆成0-(n-1)，1-n,求最大
 *
 * 解题人真聪明啊
 * 牛逼
 *
 */
public class M213 {
    public int rob(int[] nums) {
        if(nums == null)
            return 0;
        if(nums.length == 1){
            return nums[0];
        }
        int[] nums2 = new int[nums.length];
        System.arraycopy(nums,1,nums2,0,nums.length-1);
        int result = Math.max(dpArr(nums),dpArr(nums2));
        return result;
    }

    private int dpArr(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] =  Math.max(dp[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[nums.length-1];
    }
}
