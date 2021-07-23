package com.example.demo.listdemo;

import lombok.Data;

/**
 * 循环链表 节点定义
 */
@Data
public class CircleLinkTest {


    public int size;

    public CircleLinkNode head;


    public CircleLinkTest(){
        size =0;
        head= null;
    }

    //插入到链表的 末位
    public void insertDatalast(int m){
        CircleLinkNode newCode = new CircleLinkNode(m);
        if(head == null){
            head =newCode;
            newCode.next =head;
        }else{
            CircleLinkNode temp = head;
            //当下一个  等于头节点时 说明是最后一个节点了
            while(temp.next != head){
                temp =temp.next;
            }
            temp.next =newCode;
            newCode.next =head;
        }
        size++;
    }



    public boolean isContains(int k){
        CircleLinkNode temp = head;
        while(temp.next != head){
            if(temp.data.equals(k)){
                return true;
            }
            temp =temp.next;
        }
        if(temp.data.equals(k)){
            return true;
        }
        return false;
    }


    public void delete(int k){

        CircleLinkNode temp = head;
        do{
            if(temp.next.data.equals(k)){
                temp.next = temp.next.next;
                size--;
                return ;
            }else{
                temp =temp.next;
            }

        }while(temp != head);

    }


    public boolean deletelist(int obj) {
        CircleLinkNode temp = head;

        while (temp.next != head) {
            // 判断temp当前指向的结点的下一个结点是否是要删除的结点
            if (temp.next.data.equals(obj)) {
                temp.next = temp.next.next;// 删除结点
            } else {
                temp = temp.next;// temp“指针”后移
            }
        }

        return true;
    }


    public void showNodeAll(){

            int num=1;
            CircleLinkNode temp = head;
            while(temp.next != head){
                temp.showNode(num);
                temp =temp.next;
                num = num +1;
            }
            temp.showNode(num);


    }

    public void showNodeAllDo(){

        int num=1;
        CircleLinkNode temp = head;
        do{
            temp.showNode(num);
            temp = temp.next;
            num++;
        }while(temp != head);


    }
    public void insertList(int obj) {
        CircleLinkNode e = new CircleLinkNode(obj);
        e.data = obj;
        if (head.next == head)// 第一次插入元素
        {
            head.next = e;
            e.next = head;
        } else// 不是第一次插入元素
        {
            // temp引用在栈中，temp和head引用都指向堆中的initList()中new的Element对象
            CircleLinkNode temp = head;
            while (temp.next != head)// 寻找最后一个元素
            {
                temp = temp.next;
            }
            temp.next = e;
            e.next = head;// 新插入的最后一个节点指向头结点
        }
    }

    public static void main(String[] args) {
//        CircleLinkTest circleLink =new CircleLinkTest();
//        circleLink.insertDatalast(2);
//        circleLink.insertDatalast(3);
//        circleLink.insertDatalast(4);
//        circleLink.insertDatalast(5);
//        circleLink.showNodeAll();
//        System.out.println(circleLink);insertBillingsData expressid SF1123135124559

        CircleLinkTest circleLink =new CircleLinkTest();
        circleLink.insertDatalast(2);
        circleLink.insertDatalast(3);
        circleLink.insertDatalast(4);
        circleLink.insertDatalast(5);
        circleLink.showNodeAllDo();
        circleLink.delete(3);
        circleLink.showNodeAllDo();
        System.out.println(circleLink.isContains(5));
    }



}