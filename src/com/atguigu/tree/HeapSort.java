package com.atguigu.tree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 堆排序，此为大顶堆
 */
public class HeapSort {

    public static void main(String[] args) {
       // int arr[] = {4, 6, 8, 5, 9};
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int)(Math.random() * 800000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleFormatter.format(date1);
        System.out.println("排序前的时间："+ date1Str);

        heapSort(arr);

        Date date2 = new Date();
        String date2Str = simpleFormatter.format(date2);
        System.out.println("排序后的时间："+ date2Str);
    }

    public static void heapSort(int arr[]){
        int temp;
        System.out.println("堆排序！！！");
        /*
        adjustHeap(arr,1,arr.length);
        System.out.println("第一次"+ Arrays.toString(arr));

        adjustHeap(arr,0,arr.length);
        System.out.println("第一次"+ Arrays.toString(arr));
        */
         for (int i = arr.length / 2 - 1 ; i >= 0; i--) {
             adjustHeap(arr, i,arr.length);
         }

         for (int i = arr.length - 1; i > 0; i--) {
             temp = arr [i];
             arr [i] = arr[0];
             arr [0] = temp;
             adjustHeap(arr,0, i);
         }
        System.out.println("数组"+ Arrays.toString(arr));
    }

    //将一个数组（二叉树）调整成一个大顶堆

    /**
     *  完成将
     * @param arr 待调整的数组
     * @param i 非叶子节点在数组中的索引
     * @param length    表示对多少个元素进行调整
     */
    public static void adjustHeap(int arr[], int i, int length){
        int temp = arr [i];
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]){
                j++;
            }
            if(arr [j] > temp){
                arr[i] = arr[j];
                i = j;
            }else{
                break;
            }
        }
         arr [i] = temp;
    }
}
