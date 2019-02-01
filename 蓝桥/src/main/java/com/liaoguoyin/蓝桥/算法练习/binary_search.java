package com.liaoguoyin.蓝桥.算法练习;

import java.util.Scanner;

/**
 * 二分搜索
 * //译者注: Arrays.binarySearch
 * //译者注: 类名应当使用大驼峰, 例如 BinarySearch
 */
public class binary_search {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 6, 12, 32, 34, 42};
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        scanner.close();

        int low = 0, high = arr.length;
        int mid = (low + high) / 2;

        while (low <= high) {
            if (a == arr[mid]) {
                System.out.println("get it 在第" + (mid + 1) + "个");
                break;
            } else if (a > arr[mid]) {
                low = mid + 1;
                mid = (low + high) / 2;
            } else if (a < arr[mid]) {
                high = mid - 1;
                mid = (low + high) / 2;
            }
        }

        if (low > high) {
            System.out.println("exit, can not find it!");
        }

    }
}
