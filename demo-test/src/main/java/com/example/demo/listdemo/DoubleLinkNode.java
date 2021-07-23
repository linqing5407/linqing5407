package com.example.demo.listdemo;

public class DoubleLinkNode {
    //单向链表的值
    public int data;
    //下一个节点
    public DoubleLinkNode next;
    //上一个节点
    public DoubleLinkNode pre;
    //构造某个节点
    public DoubleLinkNode(DoubleLinkNode preNode, int dataT, DoubleLinkNode nextNode){
        data =dataT;
        next =nextNode;
        pre =preNode;
    }

    public void showNode(int i){
        String  nextData =(next==null?"null":next.data+"");
       String  preData =(pre==null?"null":pre.data+"");
       System.out.println(i+"当前节点"+data +"前置节点" +preData+ " 后继节点" +nextData);

    }


}