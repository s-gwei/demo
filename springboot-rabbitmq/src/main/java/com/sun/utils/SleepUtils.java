package com.sun.utils;

/**
 * @author sungw
 * @version 1.0
 * @date 2021/8/9 3:16 下午
 */
public class SleepUtils {
    public static void sleep(int second){
        try {
            Thread.sleep(1000*second);
        } catch (InterruptedException _ignored) {
            Thread.currentThread().interrupt();
        } }
}
