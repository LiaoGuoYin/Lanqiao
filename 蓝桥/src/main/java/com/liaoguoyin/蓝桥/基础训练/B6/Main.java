package com.liaoguoyin.蓝桥.基础训练.B6;

import java.util.Scanner;

/**
 * 这里主要是把控数组的下标, 搞得人头大..
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n + 1][n + 1];
        arr[1][1] = 1;

        System.out.println(arr[1][1]);
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }

    }
}
