package com.atguigu.datastructure.stack;

public class Calculator {

    public static void main(String[] args) {
        String expression = "12+6886";
        ArrayStack1 numStack = new ArrayStack1(10);//数栈
        ArrayStack1 operStack = new ArrayStack1(10);//符号栈
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        while (true){
            ch = expression.substring(index,index+1).charAt(0);
            if(operStack.isOper(ch)){
                if(!operStack.isEmpty()){
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else{
                        operStack.push(ch);
                    }
                }else{
                    operStack.push(ch);
                }
            }else {
                //numStack.push(ch - 48);
                keepNum += ch;

                if(index == expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        int val = Integer.parseInt(keepNum);
                        numStack.push(val);
                        keepNum = "";
                    }
                }
            }
            index++;
            if(index >= expression.length()){
                break;
            }
        }

        while (true){
            if (operStack.isEmpty()){
                break;
            }else {
                num1 = numStack.pop();
                num2 = numStack.pop();
                oper = operStack.pop();
                res = numStack.cal(num1,num2,oper);
                numStack.push(res);
            }
        }
        System.out.println(expression+"="+numStack.pop());
    }
}

class ArrayStack1{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack1(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public int peek(){
        return stack[top];
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

    //返回运算符的优先级
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if(oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int oper){
        int res = 0;
        switch (oper){
            case '+': res = num1 + num2;break;
            case '-': res = num2 - num1;break;
            case '*': res = num1 * num2;break;
            case '/': res = num2 / num1;break;
        }
        return res;
    }
}
