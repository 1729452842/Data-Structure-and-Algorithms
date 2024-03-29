package com.atguigu.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShellSort {

    public static void main(String[] args) {
        int arr[] = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleFormatter.format(date1);
        System.out.println("排序前的时间："+ date1Str);

        shellSort2(arr);
//        System.out.println(Arrays.toString(arr));
        Date date2 = new Date();
        String date2Str = simpleFormatter.format(date2);
        System.out.println("排序后的时间："+ date2Str);
    }

    public static void shellSort(int[] arr){
        int temp = 0;
        for (int gap = arr.length/2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j-= gap) {
                    if(arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
/*
        for (int i = 2; i < arr.length; i = i * 2) {
            int num = arr.length/i;
            for (int j = num; j < arr.length; j++) {
                for (int k = j - num; k >= 0; k -= num) {
                    if(arr[k] > arr[k + num]){
                        temp = arr[k];
                        arr[k] = arr[k + num];
                        arr[k + num] = temp;
                    }
                }
            }
//            System.out.println(Arrays.toString(arr));
        }


        for (int i = arr.length/2; i < arr.length; i++) {
            for (int j = i -5; j >= 0; j -= 5) {
                if(arr[j] > arr[j + 5]){
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        for (int i = arr.length/2/2; i < arr.length; i++) {
            for (int j = i -2; j >= 0; j -= 2) {
                if(arr[j] > arr[j + 2]){
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));


        for (int i = arr.length/2/2/2; i < arr.length; i++) {
            for (int j = i -1; j >= 0; j -= 1) {
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        */
    }

    public static void shellSort2(int[] arr){


        for (int gap = arr.length/2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[i];
                if(arr[j] < arr[j - gap]){
                    while (j - gap >= 0 && temp < arr[j - gap]){
                        arr[j] = arr[j - gap];
                        j -= gap;
                }
                    arr[j] = temp;
                }
            }
        }
    }

}
