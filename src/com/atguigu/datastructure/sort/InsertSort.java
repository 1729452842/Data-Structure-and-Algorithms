package com.atguigu.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {

    public static void main(String[] args) {
        int arr[] = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleFormatter.format(date1);
        System.out.println("排序前的时间："+ date1Str);

        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        Date date2 = new Date();
        String date2Str = simpleFormatter.format(date2);
        System.out.println("排序后的时间："+ date2Str);
    }

    public static void insertSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {

            int insertVal = arr[i];
            int insertIndex = i - 1;
            while(insertIndex >= 0 && insertVal > arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if( insertIndex + 1 != i){
                arr[insertIndex + 1] = insertVal;
            }

        }

        /*
        int insertVal = arr[1];
        int insertIndex = 0;
        while(insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println(Arrays.toString(arr));

        insertVal = arr[2];
        insertIndex = 1;
        while(insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println(Arrays.toString(arr));


        insertVal = arr[3];
        insertIndex = 2;
        while(insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println(Arrays.toString(arr));
        */
    }
}
