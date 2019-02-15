package com.liaoguoyin.pat.团体程序设计天梯赛.L1024;

import java.util.Scanner;

/**
 * L1-024 后天 （5 分）
 * 很简单，但是要注意代码格式规范（代码美观）: 任何 block 不与 if 在同一行的代码, block 都应该拥有花括号. 详见 阿里巴巴Java代码规范
 * 如果不想 硬编码 就：取余数
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt() + 2;

//      if (i == 8) i = 1;
//      if (i == 9) i = 2;
        i = i % 7;

        System.out.println(i);
    }
}
