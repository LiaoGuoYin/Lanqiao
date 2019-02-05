package com.liaoguoyin.pat.团体程序设计天梯赛.L1012;

import java.util.Scanner;

/**
 * L1-012 计算指数 （5 分）
 * <p>
 * 注意 Math.pow() 返回的是double
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        System.out.format("2^%d = %d", i, (int) Math.pow(2, i));
    }
}
