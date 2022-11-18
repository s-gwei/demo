package com.sun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * author sungw
 *
 * @description 二叉树的中序遍历
 * @date 2021/6/10
 */
public class S94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<Integer>  list = inorderTraversal(root);
        System.out.println();
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        //返回List
        List<Integer> list = new ArrayList<>();
        //递归遍历二叉树
        inorder(list,root);
        return list;
    }

    private static void inorder(List<Integer> list, TreeNode root) {
        if(root != null){
            inorder(list,root.left);
            list.add(root.val);
            inorder(list,root.right);
        }
    }
}


