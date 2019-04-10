package com.bittch.OJ;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * Auther:CHAOQIWEN
 */
public class Test5 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while(fast!=null){
                fast=fast.next;
                if(fast==null){
                    break;
                }
                slow=slow.next;
                fast=fast.next;
            }
            return slow;

        }
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        ListNode n6=new ListNode(6);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=null;

        Solution solution=new Solution();
        ListNode cur = solution.middleNode(n1);

        System.out.println(cur.val);




    }
}
