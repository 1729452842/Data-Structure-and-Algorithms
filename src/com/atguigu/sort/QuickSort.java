package com.atguigu.sort;

/*
    快速排序
 */

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {

    public static void main(String[] args) {
//        int[] arr = {-9, 78, 0, 23, -567, 70};
//        quickSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleFormatter.format(date1);
        System.out.println("排序前的时间："+ date1Str);
//        System.out.println(Arrays.toString(arr));

        quickSort(arr,0,arr.length-1);

        Date date2 = new Date();
        String date2Str = simpleFormatter.format(date2);
        System.out.println("排序后的时间："+ date2Str);
//        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right){
        int l =  left;
        int r = right;
        int pivot = arr[(left + right)/2];
        int temp = 0;
        while(l < r){
            while(arr[l] < pivot){
                l++;
            }
            while (arr[r] > pivot){
                r--;
            }

            if( l >= r){
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if(arr[l] == pivot){
                r--;
            }
            if(arr[r] == pivot){
                l++;
            }
        }

        if (l == r){
            l++;
            r--;
        }

        if(left < r){
            quickSort(arr,left,r);
        }

        if(right > l){
            quickSort(arr,l,right);
        }

    }

}
