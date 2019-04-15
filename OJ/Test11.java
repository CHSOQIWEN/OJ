package com.bittch.OJ;


import java.util.LinkedList;
import java.util.Stack;

public class Test11 {
    /**给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 有效字符串需满足：
 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。
 * Auther:CHAOQIWEN
 */
    public boolean isValid(String s) {
        //遍历每个字符，如果是左括号，压栈；
        // 如果是右括号，先查看如果栈是空的，右括号多于左括号，
        // 否则比较栈顶和这个右括号是否匹配
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            switch (ch){
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                case '}':
                case ']':{
                    if(stack.isEmpty()){
                        return false;
                    }
                    char left = stack.pop();
                    if(!((left=='('&& ch==')')||(left=='{'&& ch=='}')||(left=='['&& ch==']'))){
                        return false;
                    }
                    break;
                }
                default:
                    break;

            }
        }
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
    /**
     * 使用队列实现栈的下列操作：
     * push(x) -- 元素 x 入栈
     * pop() -- 移除栈顶元素
     * top() -- 获取栈顶元素
     * empty() -- 返回栈是否为空
     * */
   public static class MyStack {
       private LinkedList<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack() {
           this.queue =new LinkedList<>();

        }

        /** Push element x onto stack. */
        public void push(int x) {
            this.queue.addLast(x);

        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int size=this.queue.size();
            for(int i =0;i<size-1;i++){
                int v=this.queue.get(0);
                this.queue.remove(0);
                this.queue.addLast(v);
            }
            int v=this.queue.get(0);
            this.queue.remove(0);
            return v;

        }

        /** Get the top element. */
        public int top() {
            int size=this.queue.size();
            for(int i =0;i<size-1;i++){
                int v=this.queue.get(0);
                this.queue.remove(0);
                this.queue.addLast(v);
            }
            int v=this.queue.get(0);
            this.queue.remove(0);
            this.queue.addLast(v);
            return v;


        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return this.queue.size()==0;


        }
    }


    /**
     *使用栈实现队列的下列操作：
     * push(x) -- 将一个元素放入队列的尾部。
     * pop() -- 从队列首部移除元素。
     * peek() -- 返回队列首部的元素。
     * empty() -- 返回队列是否为空。
     * */
    public static class MyQueue {
        Stack<Integer> in;
        Stack<Integer> out;

        /** Initialize your data structure here. */
        public MyQueue() {
            in=new Stack<>();
            out=new Stack<>();

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            in.push(x);

        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(out.isEmpty()){
                while (!in.isEmpty()){
                    int v=in.pop();
                    out.push(v);
                }
            }
            int v=out.pop();
            return v;

        }

        /** Get the front element. */
        public int peek() {
            if(out.isEmpty()){
                while (!in.isEmpty()){
                    int v=in.pop();
                    out.push(v);
                }
            }
            int v=out.peek();
            return v;

        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return  in.isEmpty()&&out.isEmpty();

        }
    }
    /**
     * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
     * push(x) -- 将元素 x 推入栈中。
     * pop() -- 删除栈顶的元素。
     * top() -- 获取栈顶元素。
     * getMin() -- 检索栈中的最小元素。*/
    public static class MinStack {
        Stack<Integer> min;
        Stack<Integer> normal;

        /** initialize your data structure here. */
        public MinStack() {
            this.min=new Stack<>();
            this.normal=new Stack<>();

        }

        public void push(int x) {
            this.normal.push(x);
            if(this.min.isEmpty()||this.min.peek()>=x){
                this.min.push(x);
            }else {
                this.min.push(this.min.peek());
            }

        }

        public void pop() {
            this.normal.pop();
            this.min.pop();

        }

        public int top() {
            return this.normal.peek();

        }

        public int getMin() {
            return this.min.peek();

        }


    }
}




