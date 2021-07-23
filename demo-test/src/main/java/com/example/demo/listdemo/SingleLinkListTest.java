package com.example.demo.listdemo;

public class SingleLinkListTest {

    public SingleLinkNode head;
    public SingleLinkNode last;
    public int size;

    public SingleLinkListTest(){
        head =null;
        last=null;
        size= 0;
    }

    public void addFirst(int m){

        if(head ==null){
            head =new SingleLinkNode(m);
            last = new SingleLinkNode(m);
            head.next =null;
            last.next =null;
        }else{
            SingleLinkNode newNode =new SingleLinkNode(m);
            newNode.next =head;
            head = newNode;
        }
        size =size +1;
    }
    public void addLast(int m){

        if(last ==null){
            head =new SingleLinkNode(m);
            last = new SingleLinkNode(m);
            head.next =null;
            last.next =null;
        }else{
            SingleLinkNode newNode =new SingleLinkNode(m);
            last.next =newNode;
            last = newNode;

            SingleLinkNode now = head;
            while(now.next !=null){
                now = now.next;
            }
            now.next =last;
        }
        size =size +1;
    }

    public void deleteFirst(){

        if(head ==null){
          return ;
        }else{
            SingleLinkNode newNode =head.next;
            head = newNode;
        }
        size =size -1;
    }
    public void deleteLast(){

        if(head ==null||last==null){
            return ;
        }else{

            SingleLinkNode newNode =head.next;
            SingleLinkNode prenewNode =head.next;
            while(newNode.next != null){
                prenewNode = newNode;
                newNode =newNode.next;
            }
            prenewNode.next =null;

        }
        size =size -1;
    }


    public void showNodeAll(){
        SingleLinkNode now = head;
        int i=1;
        while(now !=null){
            now.showNode(i);
            now = now.next;
            i = i+1;
        }

    }

    public void addMiddle(int m, int index){

        if(index==0){
            addFirst(m);
            return;
        }
        //新增节点
        SingleLinkNode newNode =new SingleLinkNode(m);
        //新增节点的前一个节点
        SingleLinkNode preNode =head;
        for(int i=0;i<index-1;i++){
            preNode = head.next;
        }
        newNode.next = preNode.next;
        preNode.next =newNode;

        size =size +1;

    }

    public static void main(String[] args) {
        SingleLinkListTest kk =new SingleLinkListTest();
        kk.addFirst(1);
        kk.addFirst(2);
        kk.addFirst(8);
        kk.addFirst(9);
        kk.addFirst(10);
        kk.addLast(11);
        kk.showNodeAll();
        System.out.println(kk.size);
        kk.deleteFirst();
        kk.showNodeAll();
        System.out.println(kk.size);
        kk.deleteLast();
        kk.showNodeAll();
        System.out.println(kk.size);

        kk.addMiddle(9999,3);
        kk.showNodeAll();
        System.out.println(kk.size);
    }


}