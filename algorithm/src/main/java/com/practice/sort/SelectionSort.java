package com.practice.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author zengsl
 * @version V1.0
 * @date 2022/2/25 9:37 AM
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 10, 8, 4, 5, 22};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            if (minIndex != i) {
                arr[i] = arr[i] ^ arr[minIndex];
                arr[minIndex] = arr[i] ^ arr[minIndex];
                arr[i] = arr[i] ^ arr[minIndex];
            }
        }
    }
}
