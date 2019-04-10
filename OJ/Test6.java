package com.bittch.OJ;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * Auther:CHAOQIWEN
 */
public class Test6 {
    public  static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static class Solution {
        public ListNode FindKthToTail(ListNode head,int k) {
            ListNode front = head;
            ListNode back = head;

            int i;

            for( i=0;front!=null&& i<k;i++){
                front=front.next;
            }
            if(front==null&&i<k){
                return null;
            }else if(front==null){
                return head;
            }
            while(front!=null) {

                front = front.next;
                back = back.next;
            }

            return back;

        }
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

        Solution solution=new Solution();
        ListNode cur = solution.FindKthToTail(n1,1);

        System.out.println(cur.val);

    }
}
