package com.sun.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * author sungw
 *
 * @description 二叉树最大深度
 * @date 2021/6/23
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class S104 {
    /**
     * 递归解法
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    /**
     * 层次遍历
     * 递归解法
     *
     */

    public void arrangement(TreeNode Node) {
        if (Node == null) {
            return;
        }
        int depth = maxDepth(Node);
        for (int i = 1; i <= depth; i++) {
            levelOrder(Node, i);
        }
    }
    private void levelOrder(TreeNode Node, int level) {
        if (Node == null || level < 1) {
            return;
        }

        if (level == 1) {
            System.out.print(Node.val + "  ");
            return;
        }

        // 左子树
        levelOrder(Node.left, level - 1);

        // 右子树
        levelOrder(Node.right, level - 1);
    }


    /*
     * 层序遍历
     * 非递归
     */
    public void levelOrder1(TreeNode Node) {
        if (Node == null) {
            return;
        }

        TreeNode binaryNode;
        //队列，先进先出，首先将根节点入队，
        // 再出队，将根节点两个子节点入队，
        // 依次循环，根据队列先进先出特点，实现二叉树层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(Node);

        while (queue.size() != 0) {
            //出队，
            binaryNode = queue.poll();

            System.out.print(binaryNode.val + "  ");

            if (binaryNode.left != null) {
                //入队
                queue.offer(binaryNode.left);
            }
            if (binaryNode.right != null) {
                //入队
                queue.offer(binaryNode.right);
            }
        }
    }
}
