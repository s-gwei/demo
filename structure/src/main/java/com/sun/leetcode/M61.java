package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 旋转链表
 * @date 2021/5/27
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class M61 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
//        head.next.next = new ListNode(2);
        rotateRight(head,3);
        System.out.println();
    }

    public static ListNode rotateRight(ListNode head, int k) {

        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        if(head.next.next == null){
            if(k%2>0){
                ListNode temp = head;
                head = temp.next;
                head.next = temp;
                temp.next = null;
            }
            return head;
        }
        int count =1;
        ListNode temp1 = head;
        while(temp1.next!= null){
            temp1=temp1.next;
            count++;
        }
        for(int i=0;i<(k%count);i++){
            ListNode temp = head;
            //找到最后一个节点
            while(temp.next.next != null){
                temp=temp.next;
            }

            temp.next.next = head;
            head = temp.next;
            temp.next = null;

        }
        return head;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }