package com.liaoguoyin.pat.团体程序设计天梯赛.L1003;

import java.util.Scanner;

/**
 * L1-003 个位数统计
 *
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        char[] chars = s.toCharArray();
        int[] ints = new int[10];

        // 转换处理数据
        for (char each : chars) {
            int i = Integer.parseInt(Character.toString(each));
            ints[i]++;
        }

        // 输出结果
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) {
                System.out.format("%d:%d%n", i, ints[i]);
            }
        }
    }
}
