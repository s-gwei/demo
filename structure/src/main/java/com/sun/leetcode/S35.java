package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 搜索插入位置
 * @date 2021/6/1
 *
 * 给定一个排序数组和一个目标值，
 * 在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，
 * 返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 */
public class S35 {
    public static void main(String[] args) {
        int[] a = {1,3,5,6};
        int target = 7;
        int result = searchInsert(a,target);
        System.out.println(result);
    }
    public static int searchInsert(int[] nums, int target) {
          int index = 0;
          for(int i=0;i<nums.length;i++){
              if(nums[i]==target){
                  index = i;
                  break;
              }
              if( (i+1)<nums.length&&nums[i]<target && nums[i+1]>target){
                  index = i+1;
                  break;
              }
              if((i+1)==nums.length&&nums[i]<target){
                  index = i+1;
                  break;
              }
              if(i==0&&nums[i]>target){
                  break;
              }
          }
          return index;
    }
}
