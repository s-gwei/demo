package com.sun.leetcode;

/**
 * author sungw
 *
 * @description .二叉搜索树中的搜索
 * @date 2021/6/10
 *
 * 给定二叉搜索树（BST）的根节点和一个值。
 * 你需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 */
public class S700 {
    public TreeNode searchBST(TreeNode root, int val) {

        if( root==null|| root.val == val  ){
            return root;
        }
        return root.val>val?searchBST(root.left,val):searchBST(root.right,val);
    }
}
