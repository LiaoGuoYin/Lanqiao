package com.liaoguoyin.蓝桥.入门训练.A4.数组解法;

import java.util.Scanner;

/**
 * Fobinacci数列  //译者注: typo Fibonacci
 * //译者注: Java 编译器支持中文包名, 类名, 变量名
 * //译者注: Java 不支持同一个文件中存在两个 public 类. 所以通常不会特地将两个顶层类放在一个文件中
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        int n = sc1.nextInt();
        sc1.close();

        long[] F = new long[n + 2];
        F[1] = F[2] = 1;
        for (int i = 3; i <= n; i++) {
            F[i] = (F[i - 1] + F[i - 2]) % 10007;
        }

        System.out.print(F[n]);
    }
}
