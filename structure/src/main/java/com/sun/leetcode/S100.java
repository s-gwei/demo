package com.sun.leetcode;

import java.util.Scanner;

/**
 * author sungw
 *
 * @description 华为描述题
 * @date 2021/7/10
 */
public class S100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();
        int[] a = new int[m];
        int[] b = new int[n];
        for(int i=0;i<m;i++){
            a[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            b[i] = sc.nextInt();
        }

        int[] re = new int[2];
        for(int i=0;i<m;i++){
            int retult = 0;
            for(int j=0;j<n;j++){
                int ads = (a[i]-b[j]) >= 0 ? (a[i]-b[j]):(b[j] - a[i]);
                if(a[i]<=b[j] && ads<=r ){
                    int min = abs(a[i],b[j]);
                    if(retult>=min){
                        retult = min;
                        re[0] = a[i];
                        re[1] = b[j];
                    }
                }
            }
            if(re[0] != 0){
                System.out.println(re[0]+"  "+ re[1]);
                re[0]=0;
            }
        }

    }
    public static int abs(int x,int y){
        int result = x-y;
        if((result)>=0){
            return result;
        }else {
            return -result;
        }
    }


}
