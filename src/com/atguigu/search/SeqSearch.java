package com.atguigu.search;

public class SeqSearch {

    public static void main(String[] args) {
        int arr[] = {1, 9, 11, -1, 34, 89};
        int i = seqSearch(arr, -1);
        if(i == -1){
            System.out.println("查无此数！！！");
        }else {
            System.out.println("找到该数在数据中的下标为"+i);
        }
    }

    public static int seqSearch(int[] arr, int value){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
