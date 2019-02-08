package com.liaoguoyin.pat.团体程序设计天梯赛.L1016;

import java.util.Scanner;

/**
 * L1-016 查验身份证 （15 分）
 * <p>
 * 注意char a = 0; (int)a结果是48，自动转为 unicode 码了
 * 判断是否是数字：Character.isDigit(); 或者用'0'和'9'逼近
 * 把问题分解，一部分一部分的写，边写边输出看看读取到的数据对不对
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        String[] strings = new String[N];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = scanner.next();
        }

        int[] weight = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};// 各位数字的权重
        int allFlag = 1;

        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            char[] chars = s.toCharArray();

            int sum = 0;
            // 判断前17位是不是数字
            int flag = 1;
            for (int j = 0; j < chars.length - 1; j++) {
                if (chars[j] < '0' || chars[j] > '9') {
                    flag = 0;
                    System.out.format("%s%n", strings[i]);
                    allFlag = 0;// 全局pass失效
                    break;
                }
                sum = sum + weight[j] * Character.getNumericValue(chars[j]);// 加权计算
            }

            if (flag == 0)
                continue;

            int i1 = sum % 11;
            String[] strings1 = new String[]{"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};

            // 获取应正确检验值
            String check = strings1[i1];

            // 获取实际检验值
            String realCheck = Character.toString(chars[17]);

            if (!check.equals(realCheck)) {
                allFlag = 0;
                System.out.format("%s%n", strings[i]);
            }

        }
        if (allFlag == 1) {
            System.out.println("All passed");
        }
    }
}
