package com.liaoguoyin.pat.团体程序设计天梯赛.L1010;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Arrays.sort();里面的参数类型是各种数字，string[]要转int[]
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] arrstring = string.split(" ");
        int[] arr = new int[arrstring.length];
        for (int i = 0; i < arrstring.length; i++) {
            arr[i] = Integer.parseInt(arrstring[i]);
        }

        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + "->");
        }
        System.out.print(arr[arr.length - 1]);
    }
}
