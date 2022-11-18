package com.sun.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉查找树
 *链表，二叉树,二叉查找树，AVL平衡二叉树（红黑树是一种自优的二叉树），b树，b+树
 *
 *
 */

public class BinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
//        for(int i=0;i<10;i++){
//            binaryTree.add(i);
//        }
//        System.out.println("二叉树中一共有"+binaryTree.size+"个节点");
//        binaryTree.preorderNode(binaryTree.root);

        binaryTree.add(7);
        binaryTree.add(5);
        binaryTree.add(9);
        binaryTree.add(4);
        binaryTree.add(6);
        binaryTree.add(8);
        binaryTree.add(10);
        //先根遍历： 7 - 5 - 4 - 6 - 9 -8  - 10
//        binaryTree.preorderNode(binaryTree.root);
        //中根遍历: 4- 5- 6 -7-8-9-10
//        binaryTree.miorderNode(binaryTree.root);
        //后根遍历 4-6-5-8-10-9-7
//        binaryTree.posteriorNode(binaryTree.root);
        //层次遍历 7-5-9-4-6-8-10
        binaryTree.arrangement1(binaryTree.root);

        //判断二叉树是否存在某个节点
//        System.out.println(binaryTree.contain(binaryTree.root,9));
//        System.out.println(binaryTree.select(binaryTree.root,8));
        System.out.println(binaryTree.selectWhile(binaryTree.root,8));
    }

       private Node root;
       private int size;//节点个数

    /**
     * 首先我们必须找到新节点的位置，是为了保持树排序。我们必须从root节点开始，必须遵循下面的规则：
     *
     *     如果新节点小于当前的值，我们将会进入左子树
     *     如果新节点大于当前的节点。我们将会进入右子树
     *     当当前的节点是null时，我们已经到达叶子节点，我们可以添加新节点到这个位置。
     *     我们将会创建递归方法做添加节点操作
     * @param data
     * @return
     */

  public void add(int data){
      //判断跟节点是否为null
      Node temp = root;
      if(temp == null){
          Node node = new Node(data);
          root = node;
          size++;
          return;
      }
      add(root,data);
  }
  public  Node add(Node current , int data){
      if(current == null){
          size++;
          return  new Node(data);
      }
      //如果data大于current.data
      if(current.data <= data){
          current.right = add(current.right,data);
      }else{
          current.left = add(current.left,data);
      }
      return current;
  }

    //遍历节点

    /**    先序遍历
     *     先访问根节点
     *     再先序遍历左子树
     *     再先序遍历右子树
     *     退出
     */

    public void preorderNode(Node root) {
        if (root != null) {
            System.out.print(root.data+";");
            preorderNode(root.left);
            preorderNode(root.right);
        }

    }

    /**
     *      中序遍历
     *     先中序遍历左子树
     *     再访问根节点
     *     再中序遍历右子树
     *     退出
     * @param root
     */
    public void miorderNode(Node root){
        if(root != null){
            miorderNode(root.left);
            System.out.print(root.data+";");
            miorderNode(root.right);
        }
    }

    /**
     *      后序遍历
     *     先中序遍历左子树
     *     再访问根节点
     *     再中序遍历右子树
     *     退出
     * @param root
     */
    public void posteriorNode(Node root){
        if(root != null){
            posteriorNode(root.left);
            posteriorNode(root.right);
            System.out.print(root.data+";");
        }
    }

    //获取二叉树中节点个数

    public int getSize(){
        return size;
    }

    /**
     *  判断二叉树是否存在某个节点
     *
     */
    public boolean contain(Node node ,int data){
       while(node != null){
           if(node.data == data){
               return true;
           }else if(data>node.data){
               node = node.right;
               continue;
           }else{
               node = node.left;
               continue;
           }
       }
       return false;
    }
    /**
     * 查找,递归方式
     */

    public  Node select(Node root,int data){
        if(root == null){
            return null;
        }
        if(root.data > data){
            return select(root.left,data);
        }else if(root.data<data){
            return  select(root.right,data);
        }else
            return root;
    }
    /**
     * 查找,非递归方式
     */

    public Node selectWhile(Node root,int data){
        while(root != null){
            if(root.data > data){
               root = root.left;
               continue;
            }else if(root.data<data){
                root = root.right;
                continue;
            }else
                return root;
        }
        return null;
    }


    public int maxDepth(Node root) {

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

    public void arrangement(Node Node) {
        if (Node == null) {
            return;
        }
        int depth = maxDepth(Node);
        for (int i = 1; i <= depth; i++) {
            levelOrder(Node, i);
        }
    }
    private void levelOrder(Node Node, int level) {
        if (Node == null || level < 1) {
            return;
        }

        if (level == 1) {
            System.out.print(Node.data + "  ");
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
    public void arrangement1(Node Node) {
        if (Node == null) {
            return;
        }

        Node binaryNode;
        //队列，先进先出，首先将根节点入队，
        // 再出队，将根节点两个子节点入队，
        // 依次循环，根据队列先进先出特点，实现二叉树层序遍历
        Queue<Node> queue = new LinkedList<>();
        queue.add(Node);

        while (queue.size() != 0) {
            //出队，
            binaryNode = queue.poll();

            System.out.print(binaryNode.data+ "  ");

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
