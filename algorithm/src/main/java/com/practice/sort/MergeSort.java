package com.practice.sort;

import java.util.Arrays;

/**
 * Master公式(计算递归的时间复杂度)
 * T(N) = a * T(N/b) + O(N^d)
 * <p>
 * log b,a > d O(N^log(b,a))
 * log b,a = d O(N^d*logN)
 * log b,a < d O(N^d)
 *
 * @author zengsl
 * @version V1.0
 * @date 2022/2/25 11:11 AM
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 10, 8, 4, 5, 22};
        int[] results = mergeSort(arr);
        System.out.println(Arrays.toString(results));
    }


    public static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        mergeArray(arr, left, mid, right);
    }

    public static void mergeArray(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int leftStartIndex = left, rightStartIndex = mid + 1;
        int k = 0;
        while (leftStartIndex <= mid && rightStartIndex <= right) {
            if (arr[leftStartIndex] <= arr[rightStartIndex]) {
                tmp[k++] = arr[leftStartIndex++];
            } else {
                tmp[k++] = arr[rightStartIndex++];
            }
        }

        while (leftStartIndex <= mid) {
            tmp[k++] = arr[leftStartIndex++];
        }

        while (rightStartIndex <= right) {
            tmp[k++] = arr[rightStartIndex++];
        }

        for (int i = 0; i < k; i++) {
            arr[left + i] = tmp[i];
        }

        /*if (k >= 0) {
            System.arraycopy(tmp, 0, arr, left, k);
        }*/
    }
}
