package com.atguigu.recursion;

import java.util.Stack;

public class RecursionTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(9);
        test(stack.pop(),stack);
    }

    public static void test(int n,Stack<Integer> stack){
        int i = 0;
        if(stack.size() > 0){
            i = stack.pop();
            test(i,stack);
        }
        System.out.println("i="+i);
    }
}
