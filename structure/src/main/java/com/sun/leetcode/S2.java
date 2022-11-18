package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 两数相加
 * @date 2021/5/18
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class S2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next =  new ListNode(9);
        l1.next.next.next =  new ListNode(9);
        l1.next.next.next.next =  new ListNode(9);
        l1.next.next.next.next.next =  new ListNode(9);
        l1.next.next.next.next.next.next =  new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next =  new ListNode(9);
        l2.next.next.next =  new ListNode(9);
        ListNode l3 =  addTwoNumbers(l1,l2);
        System.out.println();
    }

        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int ten = 0;
            int total = ten + l1.val + l2.val;
            if (total >= 10) {
                total = total % 10;
                ten++;
            }
            ListNode l3 = new ListNode(total);
            ListNode temp = l3;
            l1=l1.next;
            l2=l2.next;
            while (l1 != null || l2 != null) {
                int l1a = 0;
                int l2a = 0;
                if (l1 != null) {
                    l1a = l1.val;
                    l1=l1.next;
                }
                if (l2 != null) {
                    l2a = l2.val;
                    l2=l2.next;
                }
                total = ten + l1a + l2a;
                ten = 0;
                if (total >= 10) {
                    total = total % 10;
                    ten++;
                }

                ListNode node = new ListNode(total);
                temp.next = node;
                temp = node;
            }
            if(ten>0){
                ListNode node = new ListNode(1);
                temp.next = node;
                temp = node;
            }
            return l3;
        }
}
