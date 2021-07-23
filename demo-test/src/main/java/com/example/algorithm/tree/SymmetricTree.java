package com.example.algorithm.tree;

import java.util.List;

public class SymmetricTree {


    // [1,2,2,null,3,null,3]
    public static void main(String[] args) {
        TreeNode firstTreeNode = new TreeNode(1);
        TreeNode leftTree = new TreeNode(2);
        TreeNode rightTree = new TreeNode(2);
        firstTreeNode.left = leftTree;
        firstTreeNode.right = rightTree;

       // TreeNode leftTree1 = new TreeNode(4);
        TreeNode rightTree1 = new TreeNode(3);
        //leftTree.left = leftTree1;
        leftTree.right = rightTree1;

       // TreeNode leftTree2 = new TreeNode(3);
        TreeNode rightTree2 = new TreeNode(3);
        //rightTree.left = leftTree2;
        rightTree.right = rightTree2;
        boolean mm =check(firstTreeNode ,firstTreeNode);
        System.out.println(mm);
    }


    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }


}
