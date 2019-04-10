package com.bittch.OJ;

/**
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 * Auther:CHAOQIWEN
 */
public class Test4 {
    public  static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static class Partition {
        public ListNode partition(ListNode pHead, int x) {
            ListNode small=null;
            ListNode big=null;
            ListNode smallLast=null;
            ListNode bigLast=null;
            ListNode cur = pHead;
            while (cur!=null){
                ListNode next = cur.next;
                if(cur.val<x){

                    cur.next=null;
                    if(small==null){
                        small=cur;

                    }else {
                        smallLast.next=cur;
                    }
                    smallLast=cur;

                }else {
                    if(big==null){
                        cur.next=null;
                        big=cur;
                    }else {
                        bigLast.next=cur;
                    }
                    bigLast=cur;

                }
                cur=next;
            }
            //考虑其中链表为null的情况
            if(small == null){
                return big;
            }else {
                smallLast.next=big;
                return small;

            }

        }
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(9);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(7);
        ListNode n5=new ListNode(5);
        ListNode n6=new ListNode(8);
        ListNode n7=new ListNode(1);
        ListNode n8=new ListNode(6);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=n8;
        n8.next=null;

        Partition partition=new Partition();
        ListNode  cur=partition.partition(n1,5);
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }

    }
}
