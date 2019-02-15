package com.liaoguoyin.pat.团体程序设计天梯赛.L1051;

import java.util.Scanner;

/**
 * L1-051 打折 （5 分）
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int price = scanner.nextInt();
        int promotion = scanner.nextInt();

        System.out.format("%.2f", price * promotion * 0.1);
    }
}
