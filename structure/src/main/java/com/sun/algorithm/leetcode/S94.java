package com.sun.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author sungw
 * @Date 2023/2/4 16:14
 * 二叉樹的中序遍历
 **/
public class S94 {
    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
//        inorderTraversal(root);
        List<Integer> list = inorderTraversalWhile(root);
        for(Integer i : list){
            System.out.println(i);
        }
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if(root != null){
            inorder(root.left,list);
            list.add(root.val);
            System.out.print(root.val+";");
            inorder(root.right,list);
        }
    }

    /**
     * # 中序遍历 先遍历左子树->根节点->右子树
     * # 如果是递归做法则递归遍历左子树，访问根节点，递归遍历右子树
     * # 非递归过程即:先访问..最左子树..结点，再访问其父节点，再访问其兄弟
     * # while循环条件 中序遍历需先判断当前结点是否存在，若存在则将该节点放入栈中，再将当前结点设置为结点的左孩子，
     * # 若不存在则取栈顶元素为cur，当且仅当栈空cur也为空，循环结束。
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalWhile(TreeNode root) {
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
        return list;
    }

}
