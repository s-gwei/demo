package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 二叉树
 * @date 2021/6/10
 */
public class TreeNode {
    public  int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
