package com.liaoguoyin.pat.团体程序设计天梯赛.L1048;

import java.util.Scanner;

/**
 * L1-048 矩阵A乘以B （15 分）
 * TOdo
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Row1 = scanner.nextInt();
        int Column1 = scanner.nextInt();

        int[][] arr1 = new int[Row1][Column1];
        for (int i = 0; i < Row1; i++) {
            for (int j = 0; j < Column1; j++) {
                arr1[i][j] = scanner.nextInt();
            }
        }

        int Row2 = scanner.nextInt();
        int Column2 = scanner.nextInt();
        int[][] arr2 = new int[Row2][Column2];
        for (int i = 0; i < Row2; i++) {
            for (int j = 0; j < Column2; j++) {
                arr2[i][j] = scanner.nextInt();
            }
        }

        // Calculate
        if (Column2 != Row2) {
            System.out.format("Error: %d != %d", Column2, Row2);
        } else {
            int[][] result = new int[Row1][Column2];
            int tmp = 0;

            for (int i = 0; i < Row1; i++) {
                for (int j = 0; j < Column2; j++) {
                    result[i][j] = arr1[i][0] * arr2[j][0];
                }
            }

        }


    }
}
