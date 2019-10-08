package com.atguigu.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectSort {

    public static void main(String[] args) {

        int arr[] = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleFormatter.format(date1);
        System.out.println("排序前的时间："+ date1Str);

        selectSort(arr);
        Date date2 = new Date();
        String date2Str = simpleFormatter.format(date2);
        System.out.println("排序后的时间："+ date2Str);
    }

    public static void selectSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
           int min = arr[minIndex];
            for (int j = i+1; j < arr.length; j++) {
                if (min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }


}
