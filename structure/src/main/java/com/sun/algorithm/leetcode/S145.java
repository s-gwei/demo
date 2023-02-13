package com.sun.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author sungw
 * @Date 2023/2/4 22:05
 * 后根遍历
 **/
public class S145 {
    @Test
    public void test(){

    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        postorder(root, list);
        return list;
    }

    private void postorder(TreeNode root, List<Integer> list) {
        if(root != null){
            postorder(root.left, list);
            postorder(root.right, list);
            list.add(root.val);
        }
    }

    private List<Integer> postOrder(TreeNode root){
        if(root == null){
            return new ArrayList<Integer>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
            list.add(0, node.val);
        }
        return list;
    }

}
