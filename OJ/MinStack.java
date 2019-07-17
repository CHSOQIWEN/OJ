package com.bittch.OJ.xianxingbiao;

/**
 * @author CHAOQIWEN
 * @data 2019/7/17 11:23
 */
public class MinStack {
    int[] stack=new int[10];
    int i=0;//i代表stack下标

    int[] minStack=new int[10];
    int j=0;//最小栈


    /** initialize your data structure here. */
   /* public MinStack() {

    }
*/
    public void push(int x) {
        stack[i++]=x;
        if(j==0){
            minStack[j++]=x;
        }else {
            if(x<minStack[j-1]){
                minStack[j++]=x;
            }
        }


    }

    public void pop() {
        if(i!=0){
            int data=stack[--i];
            if(data==minStack[j-1]){
                --j;
            }
        }

    }

    public int top() {
      if(i!=0){
          return stack[i-1];
      }
      return -1;
    }

    public int getMin() {
        if(j==0){
            return -1;
        }
        return minStack[j-1];

    }
}
