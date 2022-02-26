package com.practice.sort;

import java.util.Arrays;

/**
 * 插入排序
 * O(N^2) 但是要比冒泡和选择更好一些 跟样本有关
 *
 * @author zengsl
 * @version V1.0
 * @date 2022/2/25 9:37 AM
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 10, 8, 4, 5, 22};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        /*int current;
        for (int i = 1; i < arr.length; i++) {
            current = arr[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }*/

        // 0 ~ i 上有序
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                arr[j] = arr[j] ^ arr[j + 1];
                arr[j + 1] = arr[j] ^ arr[j + 1];
                arr[j] = arr[j] ^ arr[j + 1];
            }
        }
    }
}
