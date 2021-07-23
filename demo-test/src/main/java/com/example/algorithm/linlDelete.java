package com.example.algorithm;

public class linlDelete {

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
        ListNode listNode = new ListNode(5);
        listNode =addFirst( listNode, 4);
        listNode =addFirst( listNode, 3);
        listNode =addFirst( listNode, 2);
        listNode = addFirst( listNode, 1);
        ListNode listNodeRe =removeNth(listNode,6);
        int mm = 0;
    }


    public static ListNode removeNth(ListNode head, int n) {
        // 头部插入一个节点，不用考虑第一个节点没有前驱节点的情况
        ListNode newNode = new ListNode(0, head);
        ListNode currentNode = newNode;
        for (int i = 1; i< n ; i++){

            currentNode = currentNode.next;
            // 防止越界
            if (currentNode.next == null){
                return head;
            }
        }
        currentNode.next = currentNode.next.next;
        return newNode.next;
    }

    public static ListNode removeNthFromEnd33(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }



    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        // 第一个指针先走N步
        for (int i =0 ; i < n ; i++){
            if(first.next == null){
                return head.next;
            }
            first = first.next;

        }
        // 前后两个指针歩长一致 第一个指针到底了 第二个指针正好再前一位
        while(first.next !=null){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return head;
    }

//    public static ListNode removeNthFromEnd(ListNode head, int n) {
//// 记录链表的长度
//        int allCount = 1;
//        ListNode currentNode = head;
//        while (currentNode.next !=null){
//            currentNode = currentNode.next;
//            allCount =allCount +1;
//        }
//        // 将倒序的N换成正序的 count -N
//        if ( allCount < n){
//            // 转换成正序的第 nums位子 3
//            return head;
//        }
//        int nums = allCount - n;
//        ListNode currentNodenew = head;
//        // 当前层数
//        int currentCount = 1;
//
//        while (currentNodenew.next != null){
//
//            currentNodenew = currentNodenew.next;
//            // 移除该位置
//            if(currentCount == nums && currentNodenew.next != null){
//                currentNodenew.next = currentNodenew.next.next;
//            }
//            currentCount = currentCount + 1;
//        }
//        return head;
//    }
}
