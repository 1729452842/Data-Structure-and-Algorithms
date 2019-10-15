package com.atguigu.algorithm.kmp;

import java.util.Arrays;

public class KMPAlgorithm {

    public static void main(String[] args) {

        String s1 = "BBC ABCDAB ABCDABCDABDE";
        String s2 = "ABCDABD";
        int[] next = kmpNext("AAA");
        System.out.println(Arrays.toString(next));

    }

    public static int kmpSearch(String str1, String str2, int[] next){

        for (int i = 0, j = 0; i < str1.length();i++){

            //str1.charAt(i) != str2.charAt(j)
            while (j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next [j-1];
            }

            if (str1.charAt(i) == str2.charAt(j)){
                j++;
            }

            if(j == str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }


    public static  int[] kmpNext(String dest){

        int[] next = new int [dest.length()];
        next [0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++){

            while(j > 0 && dest.charAt(i) == dest.charAt(j)){
                j = next [j-1];
            }
            if (dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next [i] = j;
        }
        return next;
    }
}
