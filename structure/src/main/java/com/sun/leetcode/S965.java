package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 单值二叉树
 * @date 2021/6/18
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 */
public class S965 {

    private  int val ;
    private  boolean flag = true;
    public boolean isUnivalTree(TreeNode root) {
           val = root.val;
           return result(root);
    }

    public boolean result(TreeNode root){
        if(val != root.val){
            return flag = false;
        }
        if(root != null){
            result(root.left);
            result(root.right);
        }
        return flag;
    }
}
