package com.atguigu.algorithm.dac;

// 分治算法 -> 汉诺塔

/**
 * 总结：无论有多少个盘子，都可以将其看成两个（最底下n，其他(n-1)）
 *      1. (n - 1): A -> B
 *      2. n: A -> C
 *      3. (n - 1): B -> C
 */
public class Hanoitower {

    public static void main(String[] args) {
        hanoiTower(4, 'A', 'B', 'C');
    }

    public static void hanoiTower(int num, char a, char b, char c){
        if(num == 1){
            System.out.println("第1个盘从" + a + "->" + c);
        }else{
            hanoiTower(num-1, a, c, b);
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            hanoiTower(num - 1, b, a, c);
        }
    }

}
