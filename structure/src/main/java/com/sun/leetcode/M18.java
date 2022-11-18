package com.sun.leetcode;

/**
 * author sungw
 *
 * @description ��̬�滮����
 * @date 2021/6/11
 *
 * ��Ǯ�һ� II
 *
 * ����һ���������� coins ��ʾ��ͬ����Ӳ�ң����һ������ amount ��ʾ�ܽ�
 *
 * ������㲢���ؿ��Դճ��ܽ���Ӳ�������������κ�Ӳ����϶��޷��ճ��ܽ����� 0 ��
 *
 * ����ÿһ������Ӳ�������޸���
 *
 * ��Ŀ���ݱ�֤������� 32 λ������������
 *
 */
public class M18 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins ={1,2,5};
        change(amount,coins);
    }

    static int[] db ;
    public static int change(int amount, int[] coins) {

        //�����ֵ�����
          db = new int[amount+1];
        int result = dy(amount,coins);

        return result;
    }

    public static int dy(int amount, int[] coins){
        if(amount == 0){
            return 1;
        }
        if(amount < 0){
            return -1;
        }
        if(db[amount] !=0){
            return db[amount];
        }
        int res = 0;
        for(int a : coins){
            int sub = dy(amount-a,coins);
            if(sub==-1)
                continue;
            res +=sub;
        }
        db[amount] = res;
        return db[amount];

    }
}
