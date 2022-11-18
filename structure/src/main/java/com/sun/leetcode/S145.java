package com.sun.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * author sungw
 *
 * @description 二叉树后根遍历
 * @date 2021/6/25
 */
public class S145 {
        public static void main(String[] args) {
            TreeNode head = new TreeNode(1);
            head.left = new TreeNode(2);
            head.right = new TreeNode(3);
            head.left.left = new TreeNode(4);
            head.left.right = new TreeNode(5);
            head.right.left = new TreeNode(6);
            head.right.right = new TreeNode(7);
             postorderTraversal(head);
             for(int i : list){
                 System.out.println(i);
             }

        }


    static List<Integer> list;
    public static List<Integer> postorderTraversal(TreeNode root) {
        list = new ArrayList<>();
         //递归写法
//        digui(root);
        //非递归写法
        nodigui(root);
        return list;
    }

    private static void nodigui(TreeNode root) {
        if(root == null)
            return ;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null) stack.push(node.left);//和传统先序遍历不一样，先将左结点入栈
            if(node.right != null) stack.push(node.right);//后将右结点入栈
            list.add(0,node.val);                        //逆序添加结点值
        }
    }

    private void digui(TreeNode root) {
        if(root != null){
            digui(root.left);
            digui(root.right);
            list.add(root.val);
        }
    }
}
