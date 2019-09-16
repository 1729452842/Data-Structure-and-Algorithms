package com.atguigu.test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat( "0.00");
        int n, m;
        while(cin.hasNextInt())
        {
            n = cin.nextInt();
            m = cin.nextInt();
            System.out.println(select(m,n));
        }
    }

    public static double add(int n, int m){
        double[] arr = new double[m];
        double result = 0;
        arr[0] = n;
        for (int i = 1; i < m; i++) {
            arr[i] = Math.sqrt(arr[i-1]);
        }

        for (int i = 0; i < m; i++) {
            result += arr[i];
        }
        return result;
    }

    public static ArrayList<Integer> select(int m , int n){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = m; i <= n; i++){
            int a = i / 100 % 10;
            int b = i / 10 % 10;
            int c = i / 1 % 10;
            int result = (int) (Math.pow(a,3) + Math.pow(b,3) + Math.pow(c,3));
            if(result == i){
                list.add(i);
            }
        }

        return list;
    }
}
