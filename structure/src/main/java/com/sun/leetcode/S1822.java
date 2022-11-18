package com.sun.leetcode;

public class S1822 {
    public static void main(String[] args) {
        int[] a = {1,2,-4,5,7};
        System.out.println(arraySign(a));
    }
    public static int arraySign(int[] nums) {
        int product = 1;
        for(int i : nums){
              if(i == 0){
                product = 0;
            }else if (i<0){
                  product = product * -1;
            }
        }
        return product;
    }
}
