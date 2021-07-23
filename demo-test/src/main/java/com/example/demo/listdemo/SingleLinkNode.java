package com.example.demo.listdemo;

public class SingleLinkNode {
    //单向链表的值
    public int data;
    //下一个节点
    public SingleLinkNode next;
    //构造某个节点
    public SingleLinkNode(int k){
        data =k;
        next =null;
    }
    //
    public SingleLinkNode(){
       this(0);
    }

    public void showNode(int i){
        System.out.println(i+"当前节点"+data);
    }


}