package com.example.algorithm;

public class TwoLinkAll {




    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public static ListNode  addFirst(ListNode listNode,int a){
        ListNode ListNode = new ListNode(a ,listNode);
        return ListNode;
    }
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(5);
        listNode1 =addFirst( listNode1, 4);

        ListNode listNode2 = new ListNode(7);

        mergeTwoLists(listNode1,listNode2);

    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next , l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1 , l2.next);
            return l2;
        }
    }

}
