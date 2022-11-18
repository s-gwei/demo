package com.sun.recursion;

/**
 * 递归算法
 * 方法中单次递归可以使用while语句
 */
public class Digui {


    public static void main(String[] args) {
//        int a = getFactorial(4);
        int a = getFactorial1(4);
        System.out.println(a);
    }

    public static int getFactorial(int n) {
        if (n >= 0) {
            if (n == 0) {
                System.out.println(n + "!=1");
                return 1;
            } else {
                System.out.println(n);
                int temp = n * getFactorial(n - 1);
                System.out.println(n + "!=" + temp);
                return temp;
            }
        }
        return -1;
    }

    /**
     * 使用while代替单次递归
     *
     * @param n
     * @return
     */
    public static int getFactorial1(int n) {
        int result = 1;
        if (n == 0 || n == 1) {
            return n;
        }
        while (n > 0) {
           result *=n;
           n--;
        }
        return result;
    }

}
