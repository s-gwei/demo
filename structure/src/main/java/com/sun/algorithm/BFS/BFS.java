package com.sun.algorithm.BFS;

import com.sun.algorithm.DFS.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度遍历二叉树
 */
public class BFS {
    @Test
    public void test(){
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        //广度遍历
        floorBFS(head);
    }

    private void floorBFS(TreeNode head) {
        if(head == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(head);
        while(!queue.isEmpty()){
            //将队列中的元素出队。
            TreeNode root = queue.poll();
            System.out.print(root.val+";");
            if (root.left != null){
                queue.add(root.left);
            }
            if (root.right != null){
                queue.add(root.right);
            }
        }
    }
}
