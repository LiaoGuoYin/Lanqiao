package com.liaoguoyin.pat.团体程序设计天梯赛.L1010;

import java.util.Arrays;
import java.util.Scanner;

/**
 * L1-010 比较大小 （10 分）
 * <p>
 * Arrays.sort();里面的参数类型是各种数字，string[]要转int[]
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ints = new int[3];
        for (int i = 0; i < 3; i++) {
            ints[i] = scanner.nextInt();
        }

        Arrays.sort(ints);

        for (int i = 0; i < ints.length - 1; i++) {
            System.out.format("%d->", ints[i]);
        }
        System.out.print(ints[ints.length - 1]);

    }
}
