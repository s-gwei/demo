package com.sun.leetcode;

/**
 * author sungw
 *
 * @description .合并两个有序链表
 * @date 2021/6/1
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class S21 {
    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        if(l1.val>l2.val){
            temp.val = l2.val;
            l2=l2.next;
        }else{
            temp.val = l1.val;
            l1=l1.next;
        }
        ListNode head = temp;
        while(l1 != null || l2 != null){
            if(l1 == null){
                ListNode next = new ListNode(l2.val);
                temp.next = next;
                temp = next;
                l2 = l2.next;
                continue;
            }
            if(l1 == null){
                ListNode next = new ListNode(l1.val);
                temp.next = next;
                temp = next;
                l1 = l1.next;
                continue;
            }
            if(l1 != null && l2 != null){
                if(l1.val>=l2.val){
                    ListNode next = new ListNode(l2.val);
                    temp.next = next;
                    temp = next;
                    l2 = l2.next;
                    continue;
                }else{
                    ListNode next = new ListNode(l1.val);
                    temp.next = next;
                    temp = next;
                    l1 = l1.next;
                    continue;
                }
            }
        }
    return  head;
    }
}
