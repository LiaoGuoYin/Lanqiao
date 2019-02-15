package com.liaoguoyin.pat.团体程序设计天梯赛.L1018;

import java.util.Scanner;

/**
 * L1-018 大笨钟 （10 分）
 * <p>
 * 要将整点的情况特殊考虑,恶星星..
 * 译者注: 可以直接使用字符串比较, 避免大量类型转换
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        // 译者注: 不可能为 null 的值不要使用封装类型, 会导致额外装箱拆箱开销
        // Double time = Double.parseDouble(str.replace(":", "."));
        double time = Double.parseDouble(str.replace(":", "."));

        if (time <= 12.00) {
            System.out.format("Only %s.  Too early to Dang.", str);
        } else if (str.split(":")[1].equals("00")) {
            for (int i = 1; i <= (int) (time - 12); i++) {
                System.out.print("Dang");
            }
        } else {
            for (int i = 1; i <= (int) (time - 11); i++) {
                System.out.print("Dang");
            }
            System.out.println((int) (time - 11));
        }
    }
}
