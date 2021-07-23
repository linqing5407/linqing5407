package com.example.algorithm.tree;

public class MaxPathSum {


    public static void main(String[] args) {
        TreeNode firstTreeNode = new TreeNode(1);
        TreeNode leftTree = new TreeNode(2);
        TreeNode rightTree = new TreeNode(3);
        firstTreeNode.left = leftTree;
        firstTreeNode.right = rightTree;

//         TreeNode leftTree1 = new TreeNode(4);
//        TreeNode rightTree1 = new TreeNode(3);
//        leftTree.left = leftTree1;
//        leftTree.right = rightTree1;
//
//         TreeNode leftTree2 = new TreeNode(3);
//        TreeNode rightTree2 = new TreeNode(3);
//        rightTree.left = leftTree2;
//        rightTree.right = rightTree2;
        maxPathSum(firstTreeNode);
    }


    public static int maxPathSum(TreeNode treeNode){
        int maxVal = Integer.MIN_VALUE;
        int result = max(treeNode,  maxVal);
        return maxVal;
    }

    public static int max(TreeNode treeNode ,int maxVal){
        if(treeNode == null){
            return 0;
        }
        int data = treeNode.val;
        int leftVal = max(treeNode.left, maxVal);
        if(leftVal > 0){
            data =data + leftVal;
        }
        int rightVal = max(treeNode.right, maxVal);
        if(rightVal > 0){
            data = data + rightVal;
        }
        maxVal = Math.max(data, maxVal);

        return treeNode.val + Math.max(leftVal, rightVal);
    }
}
