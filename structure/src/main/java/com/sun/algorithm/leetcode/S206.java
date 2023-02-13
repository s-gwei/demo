package com.sun.algorithm.leetcode;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author sungw
 * @Date 2023/2/4 15:51
 * 翻转单向链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 **/
public class S206 {

    @Test
    public void test(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        play(reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;

        while (current != null){
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;

    }

    public void play(ListNode head){
        while (head != null){
            System.out.print(head.val+";");
            head = head.next;
        }
    }
}
