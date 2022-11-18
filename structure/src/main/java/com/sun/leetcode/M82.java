package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 删除链表中的重复元素
 * @date 2021/5/27
 */
public class M82 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        deleteDuplicates(head);
        System.out.println();
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head.next;
        ListNode preNode = head;
        //记录上一次node值
        int val= head.val;
        boolean flag = false;
        if(val==head.next.val){
            flag = true;
        }
        while(current != null){
            if(val==current.val){
                preNode.next = preNode.next.next;
                current  = preNode.next;
                continue;
            }
            preNode = current;
            current = current.next;
        }
        if(flag){
            head = head.next;
        }
       return head;
    }
}
