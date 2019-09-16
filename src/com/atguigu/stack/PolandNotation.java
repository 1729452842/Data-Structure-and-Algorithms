package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式（后缀表达式）
 */
public class PolandNotation {

    public static void main(String[] args) {
        //(3+4)*5-6
//        String suffixExpression = "1 2 3 + 4 * + 5 -";
//        List<String> rpnList = getListString(suffixExpression);
//        int res = calculate(rpnList);
//        System.out.println(res);

        String expression = "11+((22+33)*44)-55";
        List<String> list = toInfixExpressionList(expression);
        System.out.println("中缀表达式："+list);
        List<String> list1 = parseSuffixExpressionList(list);
        System.out.println("后缀表达式："+list1);
        int calculate = calculate(list1);
        System.out.println("结果"+calculate);

    }
    
    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }
    //中缀表达式转成后缀表达式
    public static List<String> parseSuffixExpressionList(List<String> ls){
        Stack<String> s1 = new Stack<String>();//符号栈
//        Stack<Integer> s2 = new Stack<Integer>();
        List<String> s2 = new ArrayList<String>();

        for (String item : ls) {
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else {
                while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while(s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;
    }


    //将中缀表达式转成对应的List
    public static List<String> toInfixExpressionList(String s){
        List<String> ls = new ArrayList<String>();
        int i = 0;
        String str;
        char c;
        do{
            if(((c = s.charAt(i)) < 48) || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            }else {
                str = "";
                while(i < s.length() && ((c = s.charAt(i)) >= 48) && ((c = s.charAt(i)) <= 57)){
                    str+=c;
                    i++;
                }
                ls.add(str);
            }
        }while (i < s.length());
        return ls;
    }

    public static int calculate(List<String> list){
        Stack<String> stack = new Stack<String>();
        for (String item : list) {
            if(item.matches("\\d+")){
                stack.push(item);
            }else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")){
                    res = num1 + num2;
                }else if(item.equals("-")){
                    res = num1 - num2;
                }else if(item.equals("*")){
                    res = num1 * num2;
                }else if(item.equals("/")){
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("运算符有误！！！");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

//返回一个运算符的优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":result = ADD;break;
            case "-":result = SUB;break;
            case "*":result = MUL;break;
            case "/":result = DIV;break;
            default: System.out.println("不存在该运算符！！！");break;
        }
        return result;
    }
}
