package com.bittch.OJ;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * Auther:CHAOQIWEN
 */
public class Test8 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static class Solution {
        public ListNode deleteDuplication(ListNode pHead) {
            if(pHead==null){
                return  null;
            }
            ListNode falsep=new ListNode(0);
            falsep.next=pHead;

            ListNode p1=pHead;
            ListNode p2=pHead.next;
            ListNode prev = falsep;

            while (p2!=null){
                if(p1.val!=p2.val){
                    prev=prev.next;
                    p1=p1.next;
                    p2=p2.next;
                }else {
                    while (p2!=null&&p2.val==p1.val){
                        p2=p2.next;
                    }
                    prev.next=p2;

                    p1=p2;
                    if(p2!=null){
                        p2=p2.next;
                    }
                }
            }
            return falsep.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=null;

        Solution solution=new Solution();
        ListNode cur = solution.deleteDuplication(n1);
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }


}
