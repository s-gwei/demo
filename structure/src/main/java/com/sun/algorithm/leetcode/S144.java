package com.sun.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author sungw
 * @Date 2023/2/4 16:48
 * 二叉树的前根遍历
 **/
public class S144 {
    @Test
    public void test(){

    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private void preorder(TreeNode root, List<Integer> list) {
        if(root != null){
            list.add(root.val);
            System.out.print(root.val);
            preorder(root.left, list);
            preorder(root.right,list);
        }
    }

    private List<Integer> preOrder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return list;

    }
}
