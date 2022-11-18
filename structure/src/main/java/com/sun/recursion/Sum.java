package com.sun.recursion;

//递归算法：1.找到结束递归的条件，也可以用只递归一次去试
//2.找到递归返回值，可以用只递归一次去试
public class Sum {

    public static void main(String[] args) {
//        int sum = sum(10);

//        int getFactorial = getFactorial(5);
//        System.out.println(getFactorial);

//        int i = 1;
//        for (i = 1; i <= 20; i++) {
//////            System.out.println("兔子第" + i + "个月的总数为:" + f(i));
////            System.out.println("兔子第" + i + "个月的总数为:" + whilef(i));
//        }
//        System.out.println("兔子第" + i + "个月的总数为:" + whilef(3));


//        System.out.println(whileSum(5));
        System.out.println(getFactorialWhile(5));
    }

    //斐波那契数列
    public static int f(int x) {
        if (x == 1 || x == 2) {
            return 1;
        } else {
            return f(x - 1) + f(x - 2);
        }
    }

    //使用while代替递归

    private static  int whileSum(int i){
        int total = 0;
        while(i>=0){
            total +=i;
            i--;
        }
    return total;
    }


    //求和递归
    private static int sum(int i) {
        if (i != 0) {
            int sun = i + sum(i - 1);
            return sun;
        }
        return 0;
    }



    //求阶乘递归
    private static int getFactorial(int a) {
        if (a > 0) {
            int temp = a * getFactorial(a - 1);
            return temp;
        } else {
            return 1;
        }
    }

    //求阶乘递归
    private static int getFactorialWhile(int a) {
      int total=1;
      while (a>0){
          total *=a;
          a--;
      }
      return total;
    }
}
