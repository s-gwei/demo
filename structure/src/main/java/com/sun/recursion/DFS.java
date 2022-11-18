package com.sun.recursion;


import java.util.Stack;

/**
 * author sungw
 *
 * @description 深度优先搜索
 * @date 2021/6/24
 */
public class DFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(10);
        dfs(root);
    }

    /**
     * 使用栈实现先根遍历
     * 相当于dfs
     * @param root
     */
    public static void dfs(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        //压栈
        stack.add(root);
        while(!stack.isEmpty()){
            //pop返回栈顶元素，并出栈
            //peek返回栈顶元素，不出栈
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if(node.right != null){
                stack.add(node.right);
            }
            if(node.left != null){
                stack.add(node.left);
            }


        }
    }
}
