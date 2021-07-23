package com.example.algorithm;

import java.util.Arrays;

public class addTwo {

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val =val;
        }
        ListNode(int val,ListNode next){
            this.val =val;
            this.next =next;
        }

    }
      //123
      //120  321
      //      21
    public ListNode add(ListNode p1 , ListNode p2){

        ListNode result = new ListNode(0);
        ListNode curentNode = result;
        int skipt = 0 ;
        while(p1 !=null || p2 != null || skipt != 0){
            //链表当前节点 不为空 去当前节点值  为空取0
            int p1Val =  p1 !=null ? p1.val : 0;
            int p2Val =  p2 !=null ? p2.val : 0;

            if(p1 != null){
                p1 = p1.next;
            }
            if(p2 != null){
                p2 = p2.next;
            }

            int sum = p1Val + p2Val + skipt ;


            // 取余数    13除 10  3
            int sumNodeVal = sum % 10;
            curentNode.next = new ListNode(sumNodeVal);
            // 相处后 取整数
            skipt = sum / 10;
            curentNode = curentNode.next;
        }

    return  result.next;

    }



    /**
     *
     * 冒泡排序
     * @params 传入数组
     */
    public static void main(String[] args) {
        int[] arrs = {10, 2, 8, 3, 9, 7, 6};
        int len = arrs.length;
        int temp ;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len-1-i; j++) {
                if(arrs[j] < arrs[j + 1]){
                    // 交换两个数
                    temp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arrs));
    }
}
