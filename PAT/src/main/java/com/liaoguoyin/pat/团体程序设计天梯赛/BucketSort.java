package com.liaoguoyin.pat.团体程序设计天梯赛;

import java.util.Arrays;

/**
 * 桶排序
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] inputNumber = {35, 99, 18, 76, 12};
        int[] resultInts = new int[100];

        for (int i = 0; i < inputNumber.length; i++) {
            resultInts[inputNumber[i]]++;
        }
        System.out.println(Arrays.toString(resultInts));

        // out
        for (int i = resultInts.length - 1; i > 0; i--) {
            for (int j = 0; j < resultInts[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }

}
