package com.sun.recursion;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * author sungw
 *
 * @description 广度优先搜索
 * @date 2021/6/24
 */
public class BFS {

    /**
     *
     * 二叉树的层序遍历就是广度优先算法
     * @param root
     */
    public void bfs(TreeNode root){
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //入队
        queue.add(root);
        if (!queue.isEmpty()) {
            //出队
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                //入队
                queue.add(node.left);
            }
            if (node.right != null) {
                //入队
                queue.add(node.right);
            }
        }
    }
}
