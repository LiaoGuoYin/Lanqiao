package com.liaoguoyin.pat.团体程序设计天梯赛.L1006;

import java.util.Scanner;

/**
 * L1-006 连续因子 （20 分）
 * TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int high = (int) Math.sqrt(number);
        // 因子一定在 [2, maxNumber] 之间

        System.out.format("因子一定在 [2, %d] 之间", high);

        int tmpResult = 0;
        while (tmpResult != number) {
            tmpResult = calculate(number, high);
            System.out.println("正在尝试:" + tmpResult);
            high--;
        }
        System.out.println("yes");
    }

    public static int calculate(int data, int maxNumber) {
        int tmp = data;
        int tmpResult = maxNumber;
        for (; tmpResult < data && tmp > 2; tmp--) {
            tmpResult = tmpResult * (tmp - 1);
        }
        return tmpResult;
    }
}
