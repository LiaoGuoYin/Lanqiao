package com.liaoguoyin.蓝桥.入门训练.A4.滑动窗口解法;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        long[] window = new long[]{1, 1, 0};

        // 处理前两个斐波那楔数
        if (n == 1) {
            System.out.println("1");
        }
        if (n == 2) {
            System.out.println("1 1");
        }

        for (int i = 3; i <= n; i++) {
            window[2] = window[0] + window[1];
            System.out.print(" " + window[2]);

            window[0] = window[1];
            window[1] = window[2];
        }
    }
}
