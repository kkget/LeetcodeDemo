package com.kk.leetcode.Day2Test;

import java.util.Stack;

/**
 * @author zhaokkstart
 * @create 2021-04-21 15:01
 */
public class StackDemo {

    public static void main(String[] args) {

        //FIFO
         Stack<Integer> stack = new Stack();
         //添加元素
        stack.push(1);
        stack.push(2);
        stack.push(3);
        //获取栈顶元素
        stack.peek();
        //删除栈元素
        stack.pop();
        //栈的大小
        stack.size();
        //是否为空
        stack.empty();
        //栈的遍历
        while (!stack.empty()){
            for (Integer integer : stack) {

            }
            stack.pop();
        }



    }

}
