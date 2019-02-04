package com.liaoguoyin.蓝桥.基础训练.B13;

import java.util.Scanner;

/**
 * 本来都要哭了，准备放弃去复习排序的时候修修改改居然又成功了 冒泡排序..
 * TODO 排序算法
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        int N = sc1.nextInt();
        int[] arr1 = new int[N];

        for (int i = 0; i < N; i++) {
            arr1[i] = sc1.nextInt();
        }
        sc1.close();

        int mid;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= N - i; j++) {
                if (arr1[j] < arr1[j - 1]) {
                    mid = arr1[j];
                    arr1[j] = arr1[j - 1];
                    arr1[j - 1] = mid;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr1[i] + " ");
        }

    }
}
