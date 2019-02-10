package com.liaoguoyin.pat.团体程序设计天梯赛.L1006;

import java.util.Scanner;

/**
 * L1-006 连续因子 （20 分）
 * 首先找出所有的因子，然后从因子里面不断的累成找到满足条件的最小连续因子
 * TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int tmp = 1;
        tmp = tmp * number;

        for (int i = 2; i < 12; i++) {
            if (tmp < number)
                tmp = tmp * i;
            else
                break;
        }

    }
}
