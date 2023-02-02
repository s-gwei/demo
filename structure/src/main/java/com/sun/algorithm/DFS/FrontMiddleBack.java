package com.sun.algorithm.DFS;

import org.junit.Test;

/**
 * 前中后，深度遍历二叉树
 * 递归实现
 */
public class FrontMiddleBack {
    @Test
    public void test(){
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        //前序遍历
//        prologue(head);

        //中序遍历
//        midlogue(head);

        //后根遍历
        follow(head);
    }

    private void follow(TreeNode head) {
        if(head != null){
            follow(head.left);
            follow(head.right);
            System.out.print(head.val+";");

        }
    }

    private void midlogue(TreeNode head) {
        if(head != null){
            System.out.print(head.val);
            midlogue(head.left);
            midlogue(head.right);
        }
    }

    private void prologue(TreeNode root) {
        if(root!=null){
            prologue(root.left);
            System.out.print(root.val+";");
            prologue(root.right);
        }
    }
}
