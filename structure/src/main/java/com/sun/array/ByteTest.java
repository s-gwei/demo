package com.sun.array;

/**
 * author sungw
 *
 * @description byte里存储数据
 * @date 2021/5/19
 *
 * byte[] bs="sss".getBytes();
 *
 * 换言之，byte[] bs="a".getBytes();
 *
 *
 * bs=[49] 即是它的asc编码
 */
public class ByteTest {
    public static void main(String[] args) {
        byte[] bytes =new byte[1];
        bytes[0] = 127;
        for (byte by:bytes){
            System.out.println(by);
        }
    }
}
