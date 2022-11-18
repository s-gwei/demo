package com.sun.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * author sungw
 *
 * @description 删除重复项
 * @date 2021/5/13
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class S26 {
    public static void main(String[] args) {
        int[] nums = {1,2,0,0,0,0,1,2,0,0};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {

        int a = 0;
       Map map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i]) != null){
                continue;
            }
        map.put(nums[i],nums[i]);
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] == nums[j]){
                    a++;
                }
            }
        }
        return  nums.length-a;
    }

}
