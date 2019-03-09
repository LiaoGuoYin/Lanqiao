package com.liaoguoyin.dataStructure;

import java.util.Arrays;

/**
 * 冒泡排序BubleSort
 * 邻居间比较，双重嵌套循环，时间复杂度O(N2)
 * 注意操作内层循环变量的时候考虑边界情况要合理，不要越界或者漏掉了
 */
public class BubleSort {
    public static void main(String[] args) {
        int[] inputNumber = {35, 99, 18, 76, 12, 21, 123, 213, 41};
        int n = inputNumber.length;

        // 从小到大输出
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= n - i; j++) {
                if (inputNumber[j - 1] > inputNumber[j]) {
                    int tmp = inputNumber[j];
                    inputNumber[j] = inputNumber[j - 1];
                    inputNumber[j - 1] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(inputNumber));

    }
}
