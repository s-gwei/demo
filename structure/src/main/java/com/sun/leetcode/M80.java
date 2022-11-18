package com.sun.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * author sungw
 *
 * @description 删除有序重复数组
 * @date 2021/5/27
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

 */
public class M80 {
    public static void main(String[] args) {
        int[] a = {1,1,1,2,2,3};
        int b =  removeDuplicates(a);
        System.out.println( b );
    }
    public static int removeDuplicates(int[] nums) {
        //标记元素出现次数
        int count=1;
        List<Integer> list = new ArrayList(nums.length);
        int[] s = new int[nums.length];
        int total = nums.length;
        for(int i=0;i<nums.length-1;i++){
            if((i+1) == nums.length){

            }
            if(nums[i] != nums[i+1]){
                if(count>=3){
                    list.add(nums[i]);
                    int a = count-2;
                    for(int j=0;j<a;j++){
                        list.remove(i-j-1);
                    }
                    total=total-count+2;
                    count=1;
                    continue;
                }
                list.add(nums[i]);
                count=1;
                continue;
            }
            list.add(nums[i]);
            count++;

        }
//        Integer[] resultList = new Integer[nums.length];
//        list.toArray(resultList);
        int[] results = new int[list.size()];
        for(int k=0;k<list.size();k++){
            results[k] = list.get(k);
        }
        nums = results;
        return  total;

    }
}
