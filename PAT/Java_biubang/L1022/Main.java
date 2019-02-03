package com.liaoguoyin.pat.团体程序设计天梯赛.L1022;

import java.util.Scanner;

/**
 * L1-022 奇偶分家
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int oushu = 0;
        int jishu = 0;
        for (int i = 1; i <= N; i++) {
            if (scanner.nextInt() % 2 == 0) {
                oushu++;
            }
        }
        System.out.printf("%s %s", N - oushu, oushu);
    }
}
