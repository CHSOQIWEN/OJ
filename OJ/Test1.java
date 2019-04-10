package com.bittch.OJ;

/**
 * 删除链表中等于给定值val的所有节点
 * Auther:CHAOQIWEN
 */
//依次遍历链表中的每一个结点，如果结点的值不是要删除的值，把结点尾插到result链表上
public class Test1 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    private static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            //ListNode result = null;
            //ListNode last = null;
            if(head==null){
                return null;
            }
            ListNode cur = head;

            /*while (cur != null) {
                ListNode next = cur.next;
                //next=cur.next;
                cur.next=null;
                if (cur.val != val) {
                    if (result == null) {
                        result = cur;
                    } else {

                        last.next = cur;

                    }
                    last = cur;
                }
                cur = next;

            }*/
            while(cur.next!=null){
                if(cur.next.val==val){
                    cur.next=cur.next.next;
                }else {
                    cur=cur.next;
                }
            }
            if(head.val==val){
                return head.next;
            }else {
                return head;
            }



        }
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(6);
        ListNode n4=new ListNode(3);
        ListNode n5=new ListNode(4);
        ListNode n6=new ListNode(5);
        ListNode n7=new ListNode(6);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=null;

        Solution solution=new Solution();
        ListNode result = solution.removeElements(n1,6);
        ListNode cur=result;
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }

    }


}
