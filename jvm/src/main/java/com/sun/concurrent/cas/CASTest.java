package com.sun.concurrent.cas;

/**
 * CAS手动实现
 */
public class CASTest {
    public static void main(String[] args) {
        CompareAndSwap cas = new CompareAndSwap();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int exportValue = cas.get();
                    boolean flag = cas.compaereAndSet(exportValue, (int) (Math.random() * 101));
                    System.out.println(flag);
                }
            }).start();
        }
    }
}

class CompareAndSwap {

    private int value;

    //获取内存值
    public synchronized int get() {
        return value;
    }

    //比较
    public synchronized int compaereAndSwap(int exportValue, int newValue) {
        int oldValue = value;
        if (oldValue == exportValue) {
            this.value = newValue;
        }
        return oldValue;
    }

    //设置
    public synchronized boolean compaereAndSet(int exportValue, int newValue) {
        return exportValue == compaereAndSwap(exportValue, newValue);
    }
}
