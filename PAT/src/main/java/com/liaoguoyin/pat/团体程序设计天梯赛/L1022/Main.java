package com.liaoguoyin.pat.团体程序设计天梯赛.L1022;

import java.util.Scanner;

/**
 * L1-022 奇偶分家 （10 分）
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int odd = 0;
        int even = 0;
        for (int i = 0; i < N; i++) {
            if (scanner.nextInt() % 2 == 0) {
                even++;
            }
        }

        System.out.printf("%s %s", N - even, even);
    }
}
