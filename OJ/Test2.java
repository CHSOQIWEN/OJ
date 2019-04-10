package com.bittch.OJ;

import java.sql.SQLOutput;

/**
 *
 *反转一个单链表
 * Auther:CHAOQIWEN
 */
public class Test2 {
    public static class ListNode {
        int val;
        ListNode next;


        ListNode(int x) {
            val = x;
        }
    }
    public static class  Solution {
        public ListNode reverseList(ListNode head){
            if(head==null){
                return  null;
            }
            ListNode prev =  null;
            ListNode cur= head;
            ListNode next = head.next;
            while(cur!=null){
                cur.next=prev;

                prev=cur;
                cur=next;
                if(next!=null) {
                    next = next.next;
                }
            }



            return prev;
        }
        /*public ListNode reverseList(ListNode head) {
            ListNode result = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = result;
                result = cur;
                cur = next;
            }
            return result;
        }*/
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=null;

        Solution solution = new Solution();
        ListNode result = solution.reverseList(n1);
        ListNode cur = result;
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }

}
