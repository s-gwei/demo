package com.sun.leetcode;

/**
 * author sungw
 *
 * @description 二叉树最小深度
 * @date 2021/6/23
 */
public class S111 {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.min(minDepth(root.left),minDepth(root.right))+1;

    }
}
