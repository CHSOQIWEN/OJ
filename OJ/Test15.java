package com.bittch.OJ.TwoForkTree;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * Auther:CHAOQIWEN
 */
public class Test15 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    class Solution {
        public int height(TreeNode root){
            if(root==null){
                return 0;
            }
            return Math.max(height(root.left),height(root.right))+1;
        }
        public boolean isBalanced(TreeNode root) {
            if(root==null){
                return true;
            }
            if(isBalanced(root.left)==false){
                return false;
            }
            if(isBalanced(root.right)==false){
                return false;
            }
            int left=height(root.left);
            int right = height(root.right);
            int diff=left-right;
            if(diff<-1||diff>1){
                return false;
            }
            return true;

        }
    }
}
