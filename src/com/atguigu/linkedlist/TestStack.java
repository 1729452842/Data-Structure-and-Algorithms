package com.atguigu.linkedlist;

import java.util.Stack;

public class TestStack{
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("jack1");
        stack.add("jack2");
        stack.add("jack3");

        while(stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
}

