package com.atguigu.datastructure.stack;

import java.util.Scanner;

public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while(loop){
            System.out.println("show：显示栈");
            System.out.println("exit：退出栈");
            System.out.println("push：添加数据到栈");
            System.out.println("pop：从栈中去除数据");
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch (key){
                case "show":arrayStack.list();break;
                case "exit":loop=false;break;
                case "push":
                    System.out.println("请输入要添加的数据：");
                    int value = scanner.nextInt();
                    arrayStack.push(value);break;
                case "pop":
                    try {
                        int pop = arrayStack.pop();
                        System.out.println("出栈的数据是"+pop);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:break;
            }
            System.out.println("退出程序！！！");
        }
    }
}

class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("栈满！！！");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空，没有数据！！！");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list(){
        if(isEmpty()){
            System.out.println("栈空，没有数据！！！");
            return;
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d\n", i , stack[i]);
        }
    }
}
