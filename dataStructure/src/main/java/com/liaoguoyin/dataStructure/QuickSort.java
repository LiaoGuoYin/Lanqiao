package com.liaoguoyin.dataStructure;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] inputNumber = {35, 99, 18, 76, 12, 21, 123, 213, 41};
        System.out.println("排序前：" + Arrays.toString(inputNumber));

        quickSort(inputNumber, 0, inputNumber.length - 1);

        System.out.println("排序后：" + Arrays.toString(inputNumber));

    }

    static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    static int partition(int[] arr, int i, int j) {
        int pivot = arr[i];
        int start = i;

        while (i != j) {
            while (arr[j] > pivot && i < j) {
                j--;
            }
            while (arr[i] < pivot && i < j) {
                i++;
            }

            if (i < j) {
                // 交换i、j
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }

        }
        arr[i] = pivot;
        return i;
    }

}