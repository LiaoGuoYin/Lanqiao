package com.liaoguoyin.pat.团体程序设计天梯赛.L1053;

import java.util.Scanner;

/**
 * L1-053 电子汪 （10 分）
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int sum = A + B;
        for (int i = 0; i < sum; i++) {
            System.out.print("Wang!");
        }
    }
}
