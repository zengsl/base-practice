package com.practice.sort;

import java.util.Arrays;

/**
 * 快速排序 3.0
 * 时间复杂度 N*logN
 * 空间复杂度 logN
 *
 * @author zengsl
 * @version V1.0
 * @date 2022/2/25 9:37 AM
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 10, 8, 4, 5, 22};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }


    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            // < 区域
            quickSort(arr, L, p[0] - 1);
            // > 区域
            quickSort(arr, p[1] + 1, R);
        }
    }

    /**
     * 返回等于区域的左右边界
     */
    public static int[] partition(int[] arr, int L, int R) {
        // < 区域的右边界
        int less = L - 1;
        // > 区域的左边界
        int more = R;
        // L 表示当前位置
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        // 将最后一位数与more进行替换，此时more其实是"等于区域的右边界"
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    /**
     * 这里不能用异或来进行替换，因为i，j可能会一样。
     */
    public static void swap(int[] arr, int i, int j) {
       /* arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];*/
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
