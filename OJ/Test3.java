package com.bittch.OJ;

/**
 * 合并两个有序链表
 * Auther:CHAOQIWEN
 */
public class Test3 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
     public static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1==null){
                return l2;
            }
            if(l2==null){
                return l1;
            }

            ListNode cur1=l1;
            ListNode cur2=l2;
            ListNode result = null;
            ListNode last = null;
            while (cur1!=null && cur2!=null){

                if(cur1.val<=cur2.val){
                   // ListNode next = cur1.next;

                    if(result==null){
                        result=cur1;
                    }else {
                        last.next=cur1;
                    }
                    last=cur1;

                    cur1=cur1.next;
                }else {
                    //ListNode next = cur2.next;

                    if(result==null){
                        result=cur2;
                    }else {
                        last.next=cur2;
                    }
                    last=cur2;

                    cur2=cur2.next;
                }
            }
            if(cur1!=null){
                last.next=cur1;
            }
            if(cur2!=null){
                last.next=cur2;
            }
            return result;

        }
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);

        ListNode n4=new ListNode(2);
        ListNode n5=new ListNode(6);
        n1.next=n2;
        n2.next=n3;
        n3.next=null;

        n4.next=n5;
        n5.next=null;

        Solution solution=new Solution();
        ListNode result = solution.mergeTwoLists(n1,n4);
        ListNode cur=result;
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }

    }

}
