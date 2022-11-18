package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 移除链表元素
 * @date 2021/6/18
 */
public class S203 {
        public ListNode removeElements(ListNode head, int val) {

            if (head == null) {
                return null;
            }
            //找到头节点是不需要删除的节点
            while (head != null) {
                if (head.val != val) {
                    break;
                }
                //如果节点都需要删除，返回null
                if (head.next == null) {
                    return null;
                }
                head = head.next;
            }
            //删除头节点之后的节点
            ListNode temp = head.next;
            ListNode pre = head;
            while (temp != null) {
                if (temp.val == val) {
                    pre.next = temp.next;
                    temp = temp.next;
                    continue;
                }
                pre = pre.next;
                temp = temp.next;
            }
            return head;
        }
}
