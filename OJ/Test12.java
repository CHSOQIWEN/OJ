package com.bittch.OJ.TwoForkTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的遍历
 * Auther:CHAOQIWEN
 */
public class Test12 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static class Solution {
        /**
         * 二叉树的前序遍历
         * */
        public  ArrayList<Integer> list;
        public  void preorder(TreeNode root){
            if(root!=null){
                list.add(root.val);
                preorder(root.left);
                preorder(root.right);
            }
        }
        public  List<Integer> preorderTraversal(TreeNode root) {
            list=new ArrayList<>();
            preorder(root);


            return list;

        }
        /**
         * 二叉树中序遍历
         * */
        public  void inorder(TreeNode root){
            if(root!=null){
                inorder(root.left);
                list.add(root.val);
                inorder(root.right);
            }
        }
        public  List<Integer> inorderTraversal(TreeNode root) {
            list=new ArrayList<>();
            inorder(root);
            return list;
        }

        /**
         * 二叉树后序遍历
         * */
        public  void postOrder(TreeNode root){
            if(root!=null){
                postOrder(root.left);
                postOrder(root.right);
                list.add(root.val);
            }
        }
        public   List<Integer> postorderTraversal(TreeNode root) {
            list=new ArrayList<>();
            postOrder(root);
            return list;

        }
    }

    public static void main(String[] args) {
        TreeNode na=new TreeNode(1);
        TreeNode nb=new TreeNode(2);
        TreeNode nc=new TreeNode(3);
        TreeNode nd=new TreeNode(4);
        TreeNode ne=new TreeNode(5);
        TreeNode nf=new TreeNode(6);
        TreeNode ng=new TreeNode(7);
        TreeNode nh=new TreeNode(8);

        na.left=nb;na.right=nc;
        nb.left=nd;nb.right=ne;
        nc.left=nf;nc.right=ng;
        ne.right=nh;

        Solution solution=new Solution();
        System.out.println(solution.preorderTraversal(na));
        System.out.println(solution.inorderTraversal(na));
        System.out.println(solution.postorderTraversal(na));
    }
}
