package com.sun.algorithm.DFS;

import org.junit.Test;

import java.util.*;

/**
 * 迭代实现深度遍历二叉树
 */
public class digui {
    @Test
    public void test(){
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        //先根遍历
//        firstRoot(head);
        //中根遍历
        secodeRoot(head);
//        后根遍历
//        lastRoot(head);
    }

    private void lastRoot(TreeNode head) {
        if(head == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        List list = new ArrayList();
        stack.push(head);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(0, node.val);
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }

        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    private void secodeRoot(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
//        return list;
    }

    private void firstRoot(TreeNode head) {
        if(head == null){
            return;
        }
        //队列是先进先出（FIFO),栈FILO
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List list = new ArrayList();
        //入栈
        stack.push(head);
        while(!stack.isEmpty()){
            //出栈
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }

        }
        System.out.println(Arrays.toString(list.toArray()));
    }
}
