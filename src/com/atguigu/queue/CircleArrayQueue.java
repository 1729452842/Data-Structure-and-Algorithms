package com.atguigu.queue;

import java.util.Scanner;

/**
 * 数组模拟环形队列
 * 条件：
 *      队列中有效的数据个数：(rear + maxSize - font) % maxSize;
 *      队列是否为满的判断条件：(rear + 1)%maxSize == font;
 *      队列是否为空的判断条件：rear == front
 */
public class CircleArrayQueue {

    public static void main(String[] args) {
        CircleArray arrayQue = new CircleArray(4);
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

class CircleArray{
    private int maxSize;
    private int font;
    private int rear;
    private int[] arr;

    public CircleArray(int arrMaxSize){
        this.maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    public boolean isFull(){
        return (rear + 1)%maxSize == font;
    }

    public boolean isEmpty(){
        return rear == font;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满！！！");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取数据！！！");
        }
         int value = arr[font];
        font = (font + 1)%maxSize;
        return value;
    }
    public int size(){
        return (rear + maxSize - font) % maxSize;
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，不能取数据！！！");
            return;
        }
        for (int i = font; i < font + size() ; i++) {
            System.out.printf("arr[%d] = %d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    public int headQueue(){
        if(isEmpty()){
            System.out.println("队列为空，不能取数据！！！");
            throw new RuntimeException("队列为空！！！");
        }
        return arr[font];
    }
}
