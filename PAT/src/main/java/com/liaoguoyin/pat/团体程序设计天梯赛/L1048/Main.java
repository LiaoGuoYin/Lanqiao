package com.liaoguoyin.pat.团体程序设计天梯赛.L1048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * L1-048 矩阵A乘以B （15 分）
 * <p>
 * 注意理清楚矩阵运算的ijk变量控制的是什么（废话一样）（控制行、列、计算过程中的增量）
 * 另外这个题目的输出非常恶心，用例的最后一行还要求格式换行
 * 测试点4有点大，必然要上Bufferedreader了
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        int row1 = Integer.parseInt(line.split(" ")[0]);
        int column1 = Integer.parseInt(line.split(" ")[1]);

        int[][] arr1 = new int[row1][column1];
        StringTokenizer stringTokenizer;
        for (int i = 0; i < row1; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < column1; j++) {
                arr1[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row2 = Integer.parseInt(stringTokenizer.nextToken());
        int column2 = Integer.parseInt(stringTokenizer.nextToken());
        int[][] arr2 = new int[row2][column2];
        for (int i = 0; i < row2; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < column2; j++) {
                arr2[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int[][] ints = new int[row1][column2];
        if (column1 != row2) {
            System.out.format("Error: %d != %d", column1, row2);
        } else {
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < column2; j++) {
                    for (int k = 0; k < row2; k++) {
                        ints[i][j] += arr1[i][k] * arr2[k][j];
                    }
                }
            }

            System.out.format("%d %d%n", row1, column2);
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < column2; j++) {
                    if (j == column2 - 1) {
                        System.out.format("%s%n", ints[i][j]);
                    } else {
                        System.out.print(ints[i][j] + " ");
                    }
                }
            }
        }

    }
}
