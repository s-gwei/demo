package com.sun.leetcode;

import java.util.*;

/**
 * author sungw
 *
 * @description 三数之和
 * @date 2021/5/25
 *
 * 给你一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

 */
public class M15 {
    public static void main(String[] args) {

        int[] nums = {1,2,-2,-1};
        List a = threeSum(nums);
        System.out.printf(String.valueOf(a.toArray()));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
//        List resultList= new ArrayList();
//        resultList =  Arrays.asList(nums);
        List<Integer> resultList = new ArrayList<Integer>(nums.length);
        for(int i=0;i<nums.length;i++){
            resultList.add(nums[i]);
        }
        Collections.sort(resultList);

        Set result = new HashSet();
        for(int i =0; i < resultList.size()-2; i++) {
            for (int j = i +1; j< resultList.size()-1; j++) {
                for(int k = resultList.size()-1; k <resultList.size()&&k>=0; k--) {
                    if( resultList.get(k)<0){
                        break;
                    }
                    if (resultList.get(i) + resultList.get(j)+resultList.get(k) == 0) {
                        List result2 = new ArrayList();
                        result2.add(resultList.get(i));
                        result2.add(resultList.get(j));
                        result2.add(resultList.get(k));
                        Collections.sort(result2);
                        result.add(result2);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
