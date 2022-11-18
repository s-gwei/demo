package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 合并二叉树
 * @date 2021/6/15
 */
public class S617 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(3);
        head.right = new TreeNode(2);
        head.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);
        mergeTrees(head,root2);
        System.out.println();

    }
    public static TreeNode head ;
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null)
            return root2;
        if(root2 == null)
            return root1;
        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);
        return root1;
    }
}
