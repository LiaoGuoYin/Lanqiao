package com.liaoguoyin.pat.团体程序设计天梯赛.L2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * L2-015 互评成绩 （25 分）
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int studentCount = Integer.parseInt(stringTokenizer.nextToken());
        int commentCount = Integer.parseInt(stringTokenizer.nextToken());
        int outCount = Integer.parseInt(stringTokenizer.nextToken());

        double[] averageResult = new double[studentCount];
        for (int i = 0; i < studentCount; i++) {
            int[] studentMarks = new int[commentCount];
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int sum = 0;
            for (int j = 0; j < commentCount; j++) {
                studentMarks[j] = Integer.parseInt(stringTokenizer.nextToken());
                sum += studentMarks[j];
            }

            // 去掉最低分最高分,即排序后去掉下标为0和length - 1 的元素
            Arrays.sort(studentMarks);
            sum = sum - studentMarks[0] - studentMarks[studentMarks.length - 1];
            averageResult[i] = sum / ((commentCount - 2) * 1.0);

        }

        Arrays.sort(averageResult);
        for (int i = studentCount - outCount; i < studentCount - 1; i++) {
            System.out.format("%.3f ", averageResult[i]);
        }
        System.out.format("%.3f", averageResult[studentCount - 1]);
    }
}
