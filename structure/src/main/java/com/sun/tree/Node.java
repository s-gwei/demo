package com.sun.tree;

/**
 * 二叉树节点
 * 每个二叉树节点都有left,right,data
 */
public class Node {
     Node left;
     Node right;
     int data;

    public Node(int data) {
        this.data = data;
    }
}
