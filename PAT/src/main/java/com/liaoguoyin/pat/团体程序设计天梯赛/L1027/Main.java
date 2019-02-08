package com.liaoguoyin.pat.团体程序设计天梯赛.L1027;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * L1-027 出租 （20 分）
 * <p>
 * arr 用set储存且降序输出；
 * index 用indexof反向获取
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phone = scanner.next();
        Set<Integer> set = new HashSet<>();

        char[] phoneArr = phone.toCharArray();
        for (char each : phoneArr) {
            set.add(Character.getNumericValue(each));
        }

        // System.out.println(set);
        int[] arr = new int[set.size()];
        int i = set.size() - 1;
        for (Integer each : set) {
            arr[i] = each;
            i--;
        }


    }
}
