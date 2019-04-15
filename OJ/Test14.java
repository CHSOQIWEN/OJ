package com.bittch.OJ.TwoForkTree;

/**给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * Auther:CHAOQIWEN
 */
public class Test14 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static class Solution {
        public boolean isSame(TreeNode p,TreeNode q){
            if(p==null&&q==null){
                return true;
            }
            if(p==null||q==null){
                return false;
            }
            return p.val==q.val&&isSame(p.left,q.left)&&isSame(p.right,q.right);
        }
        public boolean find(TreeNode root,TreeNode t){
            if(root==null){
                return false;
            }
            if(isSame(root,t)){
                return true;
            }
            if(find(root.left,t)==true){
                return true;
            }
            return find(root.right,t);
        }
        public boolean isSubtree(TreeNode s, TreeNode t) {
            return find(s,t);

        }
    }

}
