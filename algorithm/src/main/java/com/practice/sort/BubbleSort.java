package com.practice.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author zengsl
 * @version V1.0
 * @date 2022/2/25 9:37 AM
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 10, 8, 4, 5, 22};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        /*for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 值交换
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }*/

        for (int e = arr.length - 1; e > 0; e--) {
            for (int j = 0; j < e; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 值交换
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
    }
}
