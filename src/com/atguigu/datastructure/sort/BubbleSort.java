package com.atguigu.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSort {

    public static void main(String[] args) {
//        int arr[] = {3, 9, -1, 10, 20};
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));

        int arr[] = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleFormatter.format(date1);
        System.out.println("排序前的时间："+ date1Str);

        bubbleSort(arr);
        Date date2 = new Date();
        String date2Str = simpleFormatter.format(date2);
        System.out.println("排序后的时间："+ date2Str);


    }

    public static void bubbleSort(int[] arr){
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0 ; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (!flag){
                break;
            }else {
                flag = false;
            }
        }
    }

}
