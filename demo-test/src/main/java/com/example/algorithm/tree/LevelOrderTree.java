package com.example.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTree {


    // [1,2,2,null,3,null,3]
    public static void main(String[] args) {
        TreeNode firstTreeNode = new TreeNode(1);
        TreeNode leftTree = new TreeNode(2);
        TreeNode rightTree = new TreeNode(3);
        firstTreeNode.left = leftTree;
        firstTreeNode.right = rightTree;

         TreeNode leftTree1 = new TreeNode(4);
        TreeNode rightTree1 = new TreeNode(5);
        leftTree.left = leftTree1;
        leftTree.right = rightTree1;

         TreeNode leftTree2 = new TreeNode(6);
        TreeNode rightTree2 = new TreeNode(7);
        rightTree.left = leftTree2;
        rightTree.right = rightTree2;

        List<List<Integer>> listResult =new ArrayList<List<Integer>>();
        dfsMax(firstTreeNode);
        int m =  maxDepth(firstTreeNode);
        levelOrdernew(firstTreeNode, listResult);
    }

    public static int dfsMax(TreeNode root){

        if(root == null){
            return 0;
        }
        int leftdep = dfsMax(root.left);
        int rightdep = dfsMax(root.right);

        return Math.max(leftdep, rightdep)  + 1;
    }

    public static void dfs(TreeNode root){

        if(root == null){
            return;
        }
        System.out.println(root.val);
        dfs(root.left);
        dfs(root.right);
    }
    /**
     * add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
     * remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
     * element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
     * offer       添加一个元素并返回true       如果队列已满，则返回false
     * poll         移除并返问队列头部的元素    如果队列为空，则返回null
     * peek       返回队列头部的元素             如果队列为空，则返回null
     * put         添加一个元素                      如果队列满，则阻塞
     * take        移除并返回队列头部的元素     如果队列为空，则阻塞
     * @param treeNode
     * @param listResult
     */
    public static void levelOrder(TreeNode treeNode, List<List<Integer>> listResult){
        // 队列先进先出
        Queue<TreeNode> rootQueue = new LinkedList<>();
        List<Integer> listCurrent = new ArrayList<Integer>();
        rootQueue.add(treeNode);
        while(rootQueue.size()>0){
            TreeNode root = rootQueue.poll();
            listCurrent.add(root.val);
            if(root.left != null){
                rootQueue.add(root.left);
            }
            if(root.right != null){
                rootQueue.add(root.right);
            }
        }

    }
    /**
     * add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
     * remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
     * element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
     * offer       添加一个元素并返回true       如果队列已满，则返回false
     * poll         移除并返问队列头部的元素    如果队列为空，则返回null
     * peek       返回队列头部的元素             如果队列为空，则返回null
     * put         添加一个元素                      如果队列满，则阻塞
     * take        移除并返回队列头部的元素     如果队列为空，则阻塞
     * @param treeNode
     * @param listResult
     */
    public static void levelOrdernew(TreeNode treeNode, List<List<Integer>> listResult){
        // 队列先进先出
        Queue<TreeNode> rootQueue = new LinkedList<>();
        rootQueue.add(treeNode);
        while(rootQueue.size()>0){
            List<Integer> listCurrent = new ArrayList<Integer>();
            // 按层级遍历
            int currentLevelSize  =  rootQueue.size();
            for(int i = 0; i < currentLevelSize; i++){
                TreeNode node = rootQueue.poll();
                listCurrent.add(node.val);
                if(node.left != null){
                    rootQueue.offer(node.left);
                }
                if(node.right != null){
                    rootQueue.offer(node.right);
                }
            }
            listResult.add(listCurrent);
        }

    }

    public static int maxDepth(TreeNode root) {
        int max = 0;
        // 判断非空
        if(root == null){
            return 0;
        }
        // 队列先进先出
        Queue<TreeNode> queueList = new LinkedList<>();
        queueList.offer(root);
        // 直到所有的层级遍历好
        while (queueList.size() > 0) {
            // 记录层级
            max ++;
            int size = queueList.size();
            for (int i = 0; i < size; i++){
                // 上一层的全部出队
                TreeNode currentNode = queueList.poll();
                // 记录下一层下一层的入队
                if(currentNode.left != null){
                    queueList.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queueList.offer(currentNode.right);
                }
            }

        }

        return max;
    }
    /**
     * add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
     * remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
     * element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
     * offer       添加一个元素并返回true       如果队列已满，则返回false
     * poll         移除并返问队列头部的元素    如果队列为空，则返回null
     * peek       返回队列头部的元素             如果队列为空，则返回null
     * put         添加一个元素                      如果队列满，则阻塞
     * take        移除并返回队列头部的元素     如果队列为空，则阻塞
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listResult = new ArrayList<List<Integer>>();
        // 非空判断
        if (root == null) {
            return listResult;
        }
        // 队列存储 先进先出原则 按层级遍历
        Queue<TreeNode> rootQueue = new LinkedList<>();
        // 添加根节点
        rootQueue.offer(root);
        while (rootQueue.size() > 0) {
            // 记录当前层级的所有节点
            List<Integer> currentList = new ArrayList<>();
            // 记录当前层级的长度
            int currentLevelSize = rootQueue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                // poll 队列头部弹出并移除该值
                TreeNode node = rootQueue.poll();
                currentList.add(node.val);
                // 记录下一层节点
                if (node.left != null) {
                    rootQueue.offer(node.left);
                }
                if (node.right != null) {
                    rootQueue.offer(node.right);
                }
            }
            listResult.add(currentList);
        }
        return listResult;
    }


}
