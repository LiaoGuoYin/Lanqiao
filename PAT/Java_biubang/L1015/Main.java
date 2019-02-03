package com.liaoguoyin.pat.团体程序设计天梯赛.L1015;

import java.util.Scanner;

/**
 * 没有难点，细节在于四舍五入:四舍五入的思路有Math.round() 和
 * BigDecimal.setScale(0,RoundingMode.Round_up)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String str = scanner.next();

        int row = (int) Math.round((int) N * 0.5);  //译者注: 注意此处的 redundant 提示(括号位置
        // int row = Math.round(N / 2.0f);
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(str);
            }
            System.out.println();
        }
    }
}
