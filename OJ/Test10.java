package com.bittch.OJ;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深拷贝。
 *
 * Auther:CHAOQIWEN
 */
public class Test10 {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode random;

        public ListNode(int val) {

        }

        public ListNode(int _val, ListNode _next, ListNode _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
    public  static  class Solution {
        public ListNode CopyRandomList(ListNode head) {
            ListNode cur = head;


            while (cur != null) {
                ListNode NewNode = new ListNode(cur.val);
                NewNode.next = cur.next;
                cur.next = NewNode;

                cur = cur.next.next;
            }

            cur = head;
            while (cur != null) {
                ListNode NewNode = cur.next;
                if (cur.random == null) {
                    NewNode.random = null;
                } else {
                    NewNode.random = cur.random.next;
                }
                cur = cur.next.next;
            }

            cur=head;
            ListNode result=null;
            if(head!=null){
                result=head.next;

            }

            while (cur!=null){
                ListNode NewNode = cur.next;
                cur.next=NewNode.next;
                if(NewNode.next!=null) {
                    NewNode.next = cur.next.next;
                }
                cur=cur.next;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=null;

        n1.random=n3;
        n2.random=n1;
        n3.random=n3;
        n4.random=null;

        Solution solution=new Solution();
        ListNode cur = solution.CopyRandomList(n1);
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }

    }
}
