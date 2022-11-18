package com.sun.recursion;

import java.util.LinkedList;
import java.util.Queue;

/**
 * author sungw
 *
 * @description 二叉树深度
 * @date 2021/6/23
 */
public class BinaryTree {

    /**
     * 求二叉树深度
     *
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 层序遍历二叉树
     * 利用队列先进先出特点
     * 这就是BFS广度优先算法
     */
    public void da(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
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
