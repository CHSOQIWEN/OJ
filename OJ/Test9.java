package com.bittch.OJ;

/**
 * Auther:CHAOQIWEN
 */
//判断链表是否出现交叉了
//如果交叉了，找出在那个结点上交叉了
public class Test9 {
    public  static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static class Solution {
        public int length(ListNode head){
            int len=0;
            for(ListNode cur=head;cur!=null;cur=cur.next){
                len++;
            }
            return len;
        }
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lenA=length(headA);
            int lenB=length(headB);
            int len=0;
            ListNode longer=null;
            ListNode shorter=null;
            if(lenA>lenB) {
                 len = (lenA - lenB);
                 longer=headA;
                 shorter=headB;
            }else {
                 len=lenB-lenA;
                 longer=headB;
                 shorter=headA;
            }

            for (int i=0;i<len;i++){
                longer=longer.next;

            }
            while(longer!=shorter) {

                longer = longer.next;
                shorter = shorter.next;

            }
            return longer;


        }
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(7);
        ListNode n9=new ListNode(8);

        ListNode n5=new ListNode(5);
        ListNode n6=new ListNode(6);
        ListNode n7=new ListNode(7);
        ListNode n8=new ListNode(8);


        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n9;
        n9.next=null;

        n5.next=n6;
        n6.next=n7;
        n7.next=n8;
        n8.next=null;

        Solution solution=new Solution();
        ListNode cur = solution.getIntersectionNode(n1,n5);
        if(cur!=null) {
            System.out.println(cur.val);
        }else {
            System.out.println(cur);
        }


    }

}
