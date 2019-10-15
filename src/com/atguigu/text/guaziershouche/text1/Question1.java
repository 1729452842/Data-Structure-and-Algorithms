package com.atguigu.text.guaziershouche.text1;

/*
    将 I am a boy! -> boy! a am I
 */

public class Question1 {

    public static void main(String[] args) {
        String s1 = "I am a boy!";
        StringBuilder target = new StringBuilder();
        String[] s = s1.split(" ");

        for (int i = s.length - 1; i >= 0 ; i--) {
            target.append(s[i] + " ");
        }
        System.out.println(target);
    }
}
