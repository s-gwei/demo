package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 反转二叉树
 * @date 2021/6/15
 * 翻转一棵二叉树。
 */
public class S226 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        TreeNode temp = invertTree(head);
        System.out.println();
    }
    public static TreeNode invertTree(TreeNode root) {
        if(root != null){
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;
            invertTree(root.left);
            invertTree(root.right);
        }
       return root;
    }
}
