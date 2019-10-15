package com.atguigu.text.guaziershouche.text1;

import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入钱数：");
        int n = sc.nextInt();
        sc.close();

        int coins[] = { 1, 2, 5, 10 };

        count(coins, 0, n);
        System.out.println(numcount);
    }


    // 递归
    static int numcount = 0;

    public static void count(int coins[], int index, int aim) {

        if (aim == 0) {
            numcount++;
            return;
        }
        if (index == 4) {
            return;
        }

        for (int i = 0; i * coins[index] <= aim; i++) {
            count(coins, index + 1, aim - i * coins[index]);
        }

    }
/**
 * 解法1：先将0-10的组合方法列出来，再一次递归，求出每次不同递归的最大值
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入钱数：");
        int n = sc.nextInt();
        sc.close();
        Question2 s = new Question2();
        int sum = s.calculateWays(n);
        System.out.println(sum);
    }

    int count = 0;
    int[] arr;

    public int calculateWays(int n) {
        arr = new int[n + 1];
        return calculateWays1(n);
    }
    //记忆化搜索递归
    private int calculateWays1(int n) {
        if (n < 0)
            throw new IllegalArgumentException("input wrong");
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2 || n == 3)
            return 2;
        if (n == 4 || n == 5 || n == 6 || n == 7 || n == 8 || n == 9)
            return n - 1;
        if (n == 10)
            return 11;
        if (arr[n] != 0)
            return arr[n];
        int res = 0;
        res = Math.max(Math.max(calculateWays1(n - 1) + 1, calculateWays1(n - 2) + 2), Math.max(calculateWays1(n - 5) + 4, calculateWays1(n - 10) + 11));
        arr[n] = res;
        return res;
    }
 */

/* */


}
