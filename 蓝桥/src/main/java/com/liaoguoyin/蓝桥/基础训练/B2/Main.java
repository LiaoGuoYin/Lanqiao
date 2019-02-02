package com.liaoguoyin.蓝桥.基础训练.B2;

/**
 * 做这个题主要补了一下格式化输出、还有基本类型的转换的内容...
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 32; i++) {
            String number = Integer.toBinaryString(i);
            int out = Integer.parseInt(number);
            System.out.printf("%05d%n", out);
        }
    }
}
