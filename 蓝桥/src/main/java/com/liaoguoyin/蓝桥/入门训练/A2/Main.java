package com.liaoguoyin.蓝桥.入门训练.A2;

import java.util.Scanner;

/**
 * 序列求和
 * Scanner用完nextxxx()获取要记得close()   //译者注: 可以用 try(Scanner scanner = new Scanner(System.in)) 来自动关闭
 * 我居然还傻fufu的用for循环求和再除以项数。。
 * 瓜皮得一批,做题要专注于解决问题要用脑子，不是用惯性思维;
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        long n = sc1.nextLong();
        sc1.close();
        System.out.println((1 + n) * n / 2);
    }
}
