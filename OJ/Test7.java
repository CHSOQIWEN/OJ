package com.bittch.OJ;

/**
 * 对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
 给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
 * Auther:CHAOQIWEN
 */
public class Test7 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static class PalindromeList {
        public int  length(ListNode head){
            int len=0;
            ListNode cur = head;
            while(cur!=null){
                len++;
                cur=cur.next;
            }
            return len;
        }
        public ListNode reverse(ListNode head){
            ListNode result=null;
            ListNode cur = head;
            while(cur!=null){
                ListNode next = cur.next;

                    cur.next=result;
                    result=cur;


                cur=next;
            }
            return result;

        }

        public boolean chkPalindrome(ListNode A) {
            int len = length(A);
            int halflen = len/2;

            ListNode middle = A;
            for(int i=0;i<halflen;i++){
                middle=middle.next;
            }
            ListNode r=reverse(middle);
            ListNode c1=A;
            ListNode c2=r;
            while(c1!=null&&c2!=null){
                if(c1.val!=c2.val){
                    return  false;
                }
                c1=c1.next;
                c2=c2.next;
            }
            return true;

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

        PalindromeList palindromeList = new PalindromeList();
        boolean cur = palindromeList.chkPalindrome(n1);
        System.out.println(cur);


    }
}
