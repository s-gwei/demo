package com.sun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * author sungw
 *
 * @description 三数之和
 * @date 2021/5/14
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
public class S15 {
    public static void main(String[] args) {
    int[] a= {1,0,-1,2,-2,3,-3};
        threeSum(a);
        System.out.println();
    }


    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i=0;i<(nums.length-2);i++){
            for(int j=i+1;j<(nums.length-1);j++){
                for(int k=i+2;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        int[] a = {nums[i],nums[j],nums[k]};
                        List<Integer> list1 = new ArrayList<>();
                        list1.add(nums[i]);
                        list1.add(nums[j]);
                        list1.add(nums[k]);
                        for(List<Integer> s : list){
                            if(s.get(0)!=nums[i] || s.get(0)!=nums[j]|| s.get(0)!=nums[k]){
                                list.add(list1);
                            }
                            if(s.get(0)!=nums[i] || s.get(0)!=nums[j]|| s.get(0)!=nums[k]){
                                list.add(list1);
                            }
                            if(s.get(0)!=nums[i] || s.get(0)!=nums[j]|| s.get(0)!=nums[k]){
                                list.add(list1);
                            }
                        }


                    }
                }
            }
        }
         return list;

    }
}
