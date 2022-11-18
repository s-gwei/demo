package com.sun.leetcode;



import java.util.ArrayList;
import java.util.List;

/**
 * 给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
 *
 *     目标数组 target 最初为空。
 *     按从左到右的顺序依次读取 nums[i] 和 index[i]，
 *     在 target 数组中的下标 index[i] 处插入值 nums[i] 。
 *     重复上一步，直到在 nums 和 index 中都没有要读取的元素。
 *
 * 输入：nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * 输出：[0,4,1,3,2]
 * 解释：
 * nums       index     target
 * 0            0        [0]
 * 1            1        [0,1]
 * 2            2        [0,1,2]
 * 3            2        [0,1,3,2]
 * 4            1        [0,4,1,3,2]
 *
 *
 */
public class S1389 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};
//        createTargetArray(nums,index);
        List list =  new ArrayList();
        //list中的add(index,Obj)方法，在同一个位置添加元素，后一个会向挤掉前一个，后面所有元素后移一位
        //而且这个方法，必须依次添加，不能0位置没有元素就加1位置，
        // java.lang.IndexOutOfBoundsException: Index: 4, Size: 0
        list.add(4,"1");
        list.add(0,"2");
        System.out.println(list);
    }
    public static  int[] createTargetArray(int[] nums, int[] index) {
      List list =  new ArrayList();
      int[] target = new int[nums.length];
       for(int i=0;i<nums.length;i++){
           list.add(index[i],nums[i]);
       }
       for(int j = 0;j<list.size();j++){
           target[j] = (int) list.get(j);
       }
        System.out.println(target);
       return target;
    }
}
