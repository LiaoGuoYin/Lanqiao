package com.liaoguoyin.pat.团体程序设计天梯赛.L1002;

import java.util.Scanner;

/**
 * L1-002 打印沙漏 （20 分）
 * <p>
 * 其实题目并不难，做这个题之前：理清行数和总字符数的关系，N+1 = 2 x^2,其中x表示行，N表示总字符数
 * 判断 double 的小数部分是否为0：double - i == 0是否成立
 * 上下图形是反转的，所以改最外层的循环条件就行了
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int NN = N;// copy N
        String s = scanner.next();

        double d = Math.sqrt((N + 1) / 2.0);
        int i = (int) d;

        // 判断N个字符是否刚好用完
        while (d - i != 0) {
            N--;
            d = Math.sqrt((N + 1) / 2.0);
            i = (int) d;
        }

        // 打印上半部分，j控制打印每一行，k控制每一行的打印效果
        for (int j = i; j > 0; j--) {
            for (int k = 1; k <= i - j; k++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * j - 1; k++) {
                System.out.print(s);
            }
            System.out.println();
        }

        // 打印下半部分，j控制打印每一行，k控制每一行的打印效果
        for (int j = 2; j <= i; j++) {
            for (int k = 1; k <= i - j; k++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * j - 1; k++) {
                System.out.print(s);
            }
            System.out.println();
        }
        System.out.println(NN - N);
    }
}