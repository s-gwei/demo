package com.sun.leetcode;



import java.util.ArrayList;
import java.util.List;

/**
 * author sungw
 *
 * @description 验证二叉搜索树
 * @date 2021/6/23
 */
public class M98 {


    List<Integer> list = new ArrayList();
    public boolean isValidBST(TreeNode root) {

        //递归将二叉树节点值放到root中
        digui(root);
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    private void digui(TreeNode root) {
        if(root != null){
            digui(root.left);
            list.add(root.val);
            digui(root.right);
        }
    }
}
