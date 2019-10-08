package com.atguigu.datastructure.sort;


import java.text.SimpleDateFormat;
import java.util.Date;

public class RedixSort {
    public static void main(String[] args) {
        int arr[] = new int[8000000];
        for (int i = 0; i < 80000000; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleFormatter.format(date1);
        System.out.println("排序前的时间："+ date1Str);

        redix(arr);
        Date date2 = new Date();
        String date2Str = simpleFormatter.format(date2);
        System.out.println("排序后的时间："+ date2Str);

    }

    public static void redix(int[] arr) {
        int max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        for(int i =0; i < maxLength; i++) {
            int[][] bucket = new int[10][arr.length];
            int[] bucketElementCounts = new int[10];

            for(int j = 0; j < arr.length; j++) {
                int deigitofElement = arr[j] / (int)Math.pow(10,i) % 10;
                bucket[deigitofElement][bucketElementCounts[deigitofElement]] = arr[j];
                bucketElementCounts[deigitofElement]++;
            }


            int index = 0;
            for(int k =0; k < bucketElementCounts.length ; k++) {
                if( bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCounts[k] = 0;
            }
//            System.out.println(Arrays.toString(arr));
        }


    }

}

