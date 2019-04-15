package com.bittch.OJ.TwoForkTree;


public class Test13 {
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
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * Auther:CHAOQIWEN
     */
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p==null&&q==null){
                return true;
            }
            if(p==null||q==null){
                return false;
            }
            return p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

        }
        /**
         * 给定一个二叉树，检查它是否是镜像对称的。
         * */
        public  boolean isMirror(TreeNode p,TreeNode q ){
            if(p==null&&q==null){
                return true;
            }
            if(p==null||q==null){
                return false;
            }
            return p.val==q.val
                    &&isMirror(p.right,q.left)
                    &&isMirror(p.left,q.right);

        }
        public boolean isSymmetric(TreeNode root) {
            if(root==null){
                return true;
            }
            return isMirror(root.left,root.right);

        }
    }
}
