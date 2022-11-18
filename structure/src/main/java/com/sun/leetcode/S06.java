package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 从尾到头打印链表
 * @date 2021/6/18
 */
public class S06 {

    public int[] reversePrint(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        int[] result = new int[size];
        temp = head;
        size--;
        while (temp != null) {
            result[size] = temp.val;
            temp = temp.next;
            size--;
        }
        return result;
    }
}
