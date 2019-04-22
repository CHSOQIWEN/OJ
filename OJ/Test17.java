package com.bittch.OJ.TwoForkTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test17 {
    public static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;

        }
    }
    /**你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
     空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
     * Auther:CHAOQIWEN
     */

    public static void preOrder(TreeNode root, StringBuilder stringBuilder) {
        if (root != null) {
            stringBuilder.append('(');
            stringBuilder.append(root.val);
            if (root.left == null && root.right != null) {
                stringBuilder.append("()");
            } else {
                preOrder(root.left, stringBuilder);
            }
            preOrder(root.right, stringBuilder);
            stringBuilder.append(')');
        }

    }
    public static String tree2str(TreeNode root) {

        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        preOrder(root, stringBuilder);
        stringBuilder.delete(0, 1);
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());

        return stringBuilder.toString();

    }

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
     * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
     * */
    public static boolean find(TreeNode root,TreeNode t){
        if(root==null){
            return false;
        }
        if(root==t){
            return true;
        }
        if(find(root.left,t)){
            return true;
        }
        if(find(root.right,t)){
            return true;
        }
        return false;
    }



    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root==p||root==q){
            return root;
        }
        boolean pinleft=find(root.left,p);
        boolean qinleft = find(root.left,q);

        if(pinleft&&qinleft){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(!pinleft&&!qinleft){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;


    }

    /**
     * 二叉树的层序遍历
     * */
    public  void levelOrder1(TreeNode root){
        if(root==null){
            return;
        }
        LinkedList<TreeNode> queue=new LinkedList<>();

        queue.addLast(root);

        while(!queue.isEmpty()){
            TreeNode front=queue.pollFirst();
            System.out.println(front.val);

            //不要空结点，拉下线
            if(front.left!=null){
                queue.addLast(front.left);
            }
            if(front.right!=null){
                queue.addLast(front.right);
            }
        }
    }
    /**
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     * */
    public List<List<Character>> levelOrder2(TreeNode root) {
       List<List<Character>> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        class NodeLevel{
            TreeNode node;
            int level;

            public NodeLevel(TreeNode node, int level) {
                this.node = node;
                this.level = level;
            }
        }

        LinkedList<NodeLevel> queue = new LinkedList<>();
        queue.addLast(new NodeLevel(root,0));
        while (!queue.isEmpty()){
            NodeLevel front = queue.pollFirst();
            TreeNode node=front.node;
            int level=front.level;
            if(list.size()==level){
                list.add(new ArrayList<>());
            }
            list.get(level).add(node.val);

            if(node.left!=null){
                queue.addLast(new NodeLevel(node.left,level+1));

            }
            if(node.right!=null){
                queue.addLast(new NodeLevel(node.right,level+1));

            }
        }
        return list;


    }
    /**
     * 如何判断一棵树是不是完全二叉树
     * */
    public  static boolean isComplete(TreeNode root){
        if(root==null){
            return true;
        }
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.addLast(root);
        while(true){
            TreeNode front = queue.pollFirst();
            if(front==null){
                break;
            }

            queue.addLast(root.left);
            queue.addLast(root.right);
        }
        while(!queue.isEmpty()){
            TreeNode front = queue.pollFirst();
            if(front!=null){
                return false;
            }
        }
        return true;
    }




   /**
    *
    * 将搜索树转化成双向有序链表
    * */
   public static TreeNode prev=null;
   public static TreeNode head = null;
   public static void BuildList(TreeNode node){
       node.left=prev;
       if(prev!=null){
           prev.right=node;
       }else {
           head=node;
       }
       prev=node;
   }
   public static void InOrderTraversalSearchTree(TreeNode root){
       if(root!=null){
           InOrderTraversalSearchTree(root.left);
           BuildList(root);
           InOrderTraversalSearchTree(root.right);
       }
   }
   public static TreeNode SearchTreeToSortedList(TreeNode root){
       prev=null;

       head=null;
       InOrderTraversalSearchTree(root);
       return head;
   }



}
