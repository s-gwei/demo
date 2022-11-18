package com.sun.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * author sungw
 *
 * @description 二叉树前序遍历
 * @date 2021/6/25
 */
public class S144 {
    List<Integer> list ;
    public List<Integer> preorderTraversal(TreeNode root) {
         list = new ArrayList<>();
        //递归前序遍历
        digui(root);
        //非递归方式
        nodigui(root);
        return list;

    }

    /**
     * 使用非递归方式实现二叉树前序遍历
     * @param root
     */
    private void nodigui(TreeNode root) {
        if(root == null){
            return;
        }
        //使用栈实现深度优先遍历
        Stack<TreeNode> stack = new Stack<>();
        //入栈
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null){
                stack.add(node.right);
            }
            if(node.left != null){
                stack.add(node.left);
            }
        }

    }

    private void digui( TreeNode root) {
        if(root != null){
            list.add(root.val);
            digui(root.left);
            digui(root.right);
        }
    }
}
