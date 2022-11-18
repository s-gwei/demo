package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 二叉树展开
 * @date 2021/6/25
 */
public class S114 {

    TreeNode temp;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode node = new TreeNode(root.val);
        temp = node;
        //递归
        digui(root);
        root = node.right;
        return ;
    }

    private void digui(TreeNode root) {
        if(root == null){
            temp.right = new TreeNode(root.val);
            digui(root.left);
            digui(root.right);
        }
    }

}
