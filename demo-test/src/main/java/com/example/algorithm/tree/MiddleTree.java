package com.example.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class  MiddleTree {
//[5,4,6,null,null,3,7]
    static int  pre = -10000;


    public static boolean middleCheck(TreeNode root){

        if(root == null){
            return true;
        }

        boolean l = middleCheck(root.left);

        if(root.val <= pre){
            return false;
        }
        pre = root.val;

        boolean r = middleCheck(root.right);

        return l && r;
    }
    //long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }


    public static void main(String[] args) {
        TreeNode firstTreeNode = new TreeNode(0);
//        TreeNode leftTree = new TreeNode(4);
//        TreeNode rightTree = new TreeNode(6);
//        firstTreeNode.left = leftTree;
//        firstTreeNode.right = rightTree;
        //
//        TreeNode leftTree1 = new TreeNode(4);
//        TreeNode rightTree1 = new TreeNode(5);
//        leftTree.left = leftTree1;
//        leftTree.right = rightTree1;
        //
//        TreeNode leftTree2 = new TreeNode(3);
//        TreeNode rightTree2 = new TreeNode(7);
     //   rightTree.left = leftTree2;
      //  rightTree.right = rightTree2;
        boolean mm =middleCheck(firstTreeNode);
        System.out.println(mm);
    }


//    public static boolean isValidBST(TreeNode root) {
//        List<Integer> listResult = new ArrayList<Integer>();
//        List<Boolean> list = new ArrayList<Boolean>();
//        dfs(root,list);
//        if(list.isEmpty()){
//            return true;
//        }else{
//            return false;
//        }
//
//    }


    public static void dfs(TreeNode treeNode,List<Boolean> list){
        //节点为空直接返回
        if(treeNode == null){
            return;
        }

        // 跳出条件 子树遍历完成
        if(treeNode.left == null && treeNode.right == null){
            return;
        }

        //  左子树大于节点 异常
        if(treeNode.left != null && treeNode.left.val >= treeNode.val){
            list.add(false);
            return;
        }

        // 右子树小于节点  判断不是有效二叉树
        if(treeNode.right != null && treeNode.right.val <= treeNode.val){
            list.add(false);
            return;
        }


        // 继续向下遍历判断是否符合条件 回朔递归
        dfs(treeNode.left, list);
        if(!list.isEmpty()){
            return;
        }
        dfs(treeNode.right, list);
    }

       //   1
      //   2 3
    //   4 5 6 7
    // 先序遍历 1  2  4  5  3  6  7
    public static void begin(TreeNode node){

        if(node == null){
            return;
        }
        System.out.println(node.val);
        begin(node.left);
        begin(node.right);
    }





    //      1
    //     2 3
    //   4 5 6 7
    //  中序遍历  4 2 5 1 6 3 7
    public static void middle(TreeNode node){

        if(node == null){
            return;
        }
        middle(node.left);
        System.out.println(node.val);
        middle(node.right);

    }

    //      1
    //     2 3
    //   4 5 6 7
    //  后序遍历 4 5 2 6 7 3 1
    public static void after(TreeNode node){

        if(node == null){
            return;
        }
        after(node.left);
        after(node.right);
        System.out.println(node);

    }

}
