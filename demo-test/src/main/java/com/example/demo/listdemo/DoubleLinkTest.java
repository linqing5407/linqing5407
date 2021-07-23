package com.example.demo.listdemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DoubleLinkTest {
    //单向链表的值
    public int size;
    //下一个节点
    public DoubleLinkNode head;
    //上一个节点
    public DoubleLinkNode last;


    public DoubleLinkTest(){
        size =0;
        head =null;
        last =null;
    }

    //头插
    public void addFirst(int m){
        //被插入的节点
        DoubleLinkNode f =head;
        //构建新节点 新加入的头节点  前驱节点为空
        DoubleLinkNode newNode = new DoubleLinkNode(null,m,head);
        //新节点变成头节点
        head = newNode;
        if(f == null){
         last = newNode;
        }else{
         //被插入的节点 前驱变成新加入的节点
         f.pre =newNode;
        }
        size ++;
    }
    //尾插
    public void addLast(int m){
        //被插入的节点
        DoubleLinkNode l =last;

        DoubleLinkNode newNode = new DoubleLinkNode(l,m,null);
        last = newNode;
        if(l ==null){
            head =newNode;
        }else{
            l.next =newNode;
        }
        size ++;

    }

    // 从某个节点之前插入
    public void addBefore(int m, DoubleLinkNode sourceNode){
        //获取当前节点的  前驱节点
        DoubleLinkNode pre  = sourceNode.pre;
        //再单钱节点之前插入   那么他的后继就是当前节点  前驱是当前节点的前驱节点
        DoubleLinkNode newNode =  new DoubleLinkNode(pre,m,sourceNode);
        sourceNode.pre = newNode;
        if (pre == null) {
            //前驱时空说明是 头节点 那么更新头节点就OK
            head =newNode;
        }else{
            pre.next =newNode;
        }
        size ++;
    }


    // 从某个节点之后插入
    public void addAfter(int m, DoubleLinkNode sourceNode){
        //获取当前节点的  后一个
        DoubleLinkNode net  = sourceNode.next;
        //构建单前节点位置
        DoubleLinkNode newNode = new DoubleLinkNode(sourceNode,m,net);
        //加入节点 到某节点后面
        sourceNode.next = newNode;
        if(net == null){
            last = newNode;
        }else{
            net.pre = newNode;
        }
    }

    //从头部开始遍历
    public void showAllNodes(){

        DoubleLinkNode curentNode = head;
        int num = 1;
        while(curentNode !=null){
            curentNode.showNode(num);
            curentNode = curentNode.next;
            num = num +1;
        }


    }

    //从尾部开始遍历
    public void showAllNodesByLast(){

        DoubleLinkNode curentNode = last;
        int num = 1;
        while(curentNode !=null){
            curentNode.showNode(num);
            curentNode = curentNode.pre;
            num = num +1;
        }


    }



    public static void main(String[] args) {


        DoubleLinkTest demoLast =new DoubleLinkTest();
        demoLast.addLast(10);
        demoLast.addLast(20);
        demoLast.addLast(30);
        demoLast.addLast(40);

        DoubleLinkNode source = demoLast.last.pre;

        demoLast.addBefore(28,source);

        demoLast.addAfter(33,source);
        demoLast.showAllNodes();
        System.out.println(demoLast.size);
        List<String> List =new ArrayList<>();
        LinkedList<String> listLink =new LinkedList<>();
        listLink.add("1");
        listLink.add("2");
        listLink.add("3");
        listLink.add("4");
        listLink.remove("3");
//
//
//
//        DoubleLinkTest demo =new DoubleLinkTest();
//        demo.addFirst(10);
//        demo.addFirst(20);
//        demo.addFirst(30);
//        demo.showAllNodes();
//        System.out.println(demo.size);

    }
    public static void mainNext(String[] args) {
        DoubleLinkTest demoLast =new DoubleLinkTest();
        demoLast.addLast(10);
        demoLast.addLast(20);
        demoLast.addLast(30);
        demoLast.addLast(40);
        demoLast.showAllNodes();
        System.out.println(demoLast.size);
    }


}