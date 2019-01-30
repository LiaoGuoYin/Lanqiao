package com.liaoguoyin.pat.团体程序设计天梯赛.L1019;

import java.util.Scanner;

/**
 * Pat猜拳
 * 注:当他们喝的酒超过他们的承受量的的时候才倒下
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();// A酒量
        int B = scanner.nextInt();// B酒量

        int AA = A, BB = B;
        // 猜拳数据
        int N = scanner.nextInt();// N组数据
        int[][] shuju = new int[N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                shuju[i][j] = scanner.nextInt();
            }
        }

        int sum = 0;// 猜拳喊的和
        for (int i = 0; A * B >= 0; i++) {
            sum = shuju[i][0] + shuju[i][2];
            if (sum == shuju[i][1] && sum != shuju[i][3]) {
                A--;
                // System.out.println("A 喝了 " + (i+1));
            } else if (sum != shuju[i][1] && sum == shuju[i][3]) {
                B--;
                // System.out.println("B 喝了" + i);
            } else {
                continue;   //译者注: 注意这里的 unnecessary 提示, 当 continue 是逻辑块的最后一行时不影响程序流程
            }
        }

        if (A == 0) {
            System.out.printf("A%n%s", AA);
        } else if (B == 0) {
            System.out.printf("B%n%s", BB);
        }
    }
}
