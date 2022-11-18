package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 反转链表
 * @date 2021/6/18
 */
public class S24 {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode temp = head.next;
        ListNode result = new ListNode(head.val);;
        while(temp != null){
           ListNode next = new ListNode(temp.val);
           next.next = result;
           result = next;
        }
         return result;
    }
}
