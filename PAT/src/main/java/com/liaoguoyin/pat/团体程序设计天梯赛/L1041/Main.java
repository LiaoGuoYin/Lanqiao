package com.liaoguoyin.pat.团体程序设计天梯赛.L1041;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * L1-041 寻找250 （10 分）
 * <p>
 * 先存储再 indexOf 寻找
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split(" ");
        for (String each : strings) {
            int eachInt = Integer.parseInt(each);
            list.add(eachInt);
        }

        System.out.println(list.indexOf(250) + 1);

    }
}
