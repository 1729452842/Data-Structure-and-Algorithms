package com.atguigu.queue;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQueue {

    public static void main(String[] args) {
        ArrayQue arrayQue = new ArrayQue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            key = scanner.next().charAt(0);
            switch (key){
                case 's' : arrayQue.showQueue();break;
                case 'e' :
                    scanner.close();
                    loop = false;break;
                case 'a' :
                    System.out.println("请输入一个数字");
                    int value = scanner.nextInt();
                    arrayQue.addQueue(value);break;
                case 'g' :
                    try {
                        int res = arrayQue.getQueue();
                        System.out.println("取出的数字时"+res+"\n");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h' :
                    try {
                        int res = arrayQue.headQueue();
                        System.out.println("队列头的数据是"+res+"\n");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:break;

            }
        }
        System.out.println("程序退出！！！");
    }
}

class ArrayQue{
    private int maxSize;
    private int font;
    private int rear;
    private int[] arr;

    public ArrayQue(int arrMaxSize){
        this.maxSize = arrMaxSize;
        arr = new int[maxSize];
        font = -1;//队列头部
        rear = -1;//队列尾部
    }

    public boolean isFull(){
        return rear == maxSize -1;
    }

    public boolean isEmpty(){
        return rear == font;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满！！！");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取数据！！！");
        }
        font++;
        return arr[font];
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，不能取数据！！！");
            return;
        }
        for (int i = 0; i <arr.length; i++) {
            System.out.println(arr[i]+"\t");
        }
    }

    public int headQueue(){
        if(isEmpty()){
            System.out.println("队列为空，不能取数据！！！");
            throw new RuntimeException("队列为空！！！");
        }
        return arr[font+1];
    }
}
