package com.atguigu.algorithm.kmp;

public class ViolenceMatch {

    public static void main(String[] args) {
        String s1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String s2 = "尚硅谷你尚硅你";
        int index = violenceMatch(s1, s2);
        System.out.println(index);
    }

    public static int violenceMatch(String str1, String str2){
        char [] s1 = str1.toCharArray();
        char [] s2 = str2.toCharArray();
        int s1len = s1.length;
        int s2len = s2.length;

        int i = 0;
        int j = 0;
        while (i < s1len && j < s2len){//保证匹配不越界

            if(s1[i] == s2[j]){
                i++;
                j++;
            }else{
                i = i - (j - 1);
                j = 0;
            }
        }

        if(j == s2len){
            return i - j;
        }else{
            return -1;
        }
    }
}
