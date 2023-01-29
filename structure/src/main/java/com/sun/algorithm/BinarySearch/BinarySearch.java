package com.sun.algorithm.BinarySearch;

import org.junit.Test;

import java.util.Arrays;

/**
 * 二分搜索
 *假设在[begin，end）范围内搜索某个元素 v，mid == （begin + end）/ 2
 * ①、如果v < m，去[begin ， mid）范围内二分搜索
 * ②、如果v > m，去[mid + 1， end）范围内二分搜索
 * ③、如果v == m ，直接返回 mid
 */
public class BinarySearch {
    public int binarySearch(int[] arr, int value){
        if (arr.length == 0 || arr == null)
            return  -1;
        int begin = 0;
        int end = arr.length;
        while (begin < end){
            int mid = (begin+end)>>1;
            if(value < arr[mid]){
                end = mid;
            }else if(value > arr[mid]){
                begin = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    @Test
    public void test(){
        int[] arr = {1,3,5,7,9,11,12,13,14};
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr, 4));
    }

}
