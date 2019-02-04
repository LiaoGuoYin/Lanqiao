package com.liaoguoyin.pat.团体程序设计天梯赛.L1004;

import java.util.Scanner;

/**
 * L1-004 计算摄氏温度 （5 分）
 * <p>
 * 注意题目给出的输出格式：如果输出混合了数字、符号和变量，建议使用格式化输出以提升可读性
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int F = scanner.nextInt();

        // C=5×(F−32)/9
        int C = 5 * (F - 32) / 9;
        System.out.format("Celsius = %d", C);
    }
}
