package com.sun.recursion;

import com.sun.leetcode.TreeNode;

import java.util.Queue;
import java.util.*;

/**
 * author sungw
 *
 * @description 多种方式遍历二叉树
 * @date 2021/6/25
 */
public class TraversingBinaryTree {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        //先根遍历 1-2-4-5-3-6-7
//        preorderNode(head);
        preorderDFS(head);

        //中根遍历4-2-5-1-6-3-7
//        miorderNode(head);
//        inorderDFS(head);

        //后根遍历4-5-2-6-7-3-1
//        posteriorNode(head);
        posteriorDFS(head);

        //层序遍历：1-2-3-4-5-6-7
//        floorBFS(head);
    }



    /**
     * 先根遍历,递归
     */
    public static void preorderNode(TreeNode root) {
        if (root != null) {
            System.out.print(root.val+";");
            preorderNode(root.left);
            preorderNode(root.right);
        }
    }
    /**
     * 先根遍历，迭代
     * DFS
     */
    public static void preorderDFS(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        //入栈
        stack.push(root);
        while(!stack.isEmpty()){
            //出栈，删除栈顶
            TreeNode node = stack.pop();
            System.out.print(node.val+";");
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
    }

    /**
     * 中根遍历,递归
     */
     public static void miorderNode(TreeNode root){
         if(root != null){
             miorderNode(root.left);
             System.out.print(root.val+";");
             miorderNode(root.right);
         }
     }
    /**
     * 中根遍历，迭代
     * DFS
     */
    public static void inorderDFS(TreeNode root){
        if(root == null){
            return;
        }
        //创建栈
        Stack<TreeNode> stack = new Stack<>();
        //创建list
        List<Integer> list = new ArrayList<>();
        TreeNode temp = root;
        while(temp != null || !stack.isEmpty()){
            while(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            list.add(temp.val);
            temp = temp.right;
        }
        for(int i : list){
            System.out.print(i+";");
        }
    }

    /**
     * 后根遍历，递归
     */
    public static  void posteriorNode(TreeNode root){
        if(root != null){
            posteriorNode(root.left);
            posteriorNode(root.right);
            System.out.print(root.val+";");
        }
    }

    /**
     * 后根遍历 ，迭代
     * DFS实现
     */
    public  static  void posteriorDFS(TreeNode root){
        if(root == null){
            return;
        }
        //创建栈
        Stack<TreeNode> stack = new Stack<>();
        //创建list
        List<Integer> list = new ArrayList<Integer>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            //还有个问题，就是你在一个位置一直add（index ， element）。
            // 这个不仅仅是把index位置的数据给替换啦，
            // 而且把之前这个位置的数据给依次向后移动啦，
            // 这个跟map的结构不一样，map是更新指定位置的数据，
            // 其他的数据不动，这个list竟然是把把数据平移啦。。。。。
            list.add(0,node.val);
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }

        }
        for(int i : list){
            System.out.print(i+";");
        }
    }

    /**
     * 层序遍历
     * BFS
     */
    public  static void  floorBFS(TreeNode root){
        if(root == null){
            return;
        }
        //使用队列实现层序遍历,队列先进先出，栈先进后出
        Queue<TreeNode> queue = new LinkedList<>();
        //入队
        queue.add(root);
        while(!queue.isEmpty()){
            //出队,poll()方法出队,peek()取队首元素不出队
            TreeNode node = queue.poll();
            System.out.print(node.val+";");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }
}
