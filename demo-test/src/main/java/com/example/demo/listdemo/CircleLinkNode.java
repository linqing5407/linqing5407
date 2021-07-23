package com.example.demo.listdemo;

/**
 * 循环链表 节点定义
 */
public class CircleLinkNode<T> {
    //单向链表的值
    public T data;

    public CircleLinkNode next;


   public CircleLinkNode(T datas){
        data =datas;
    }

    public void showNode(int i){
        System.out.println(i+"当前节点"+data);
    }
}