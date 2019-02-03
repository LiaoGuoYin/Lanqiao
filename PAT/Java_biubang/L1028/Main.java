package com.liaoguoyin.pat.团体程序设计天梯赛.L1028;

import java.util.Scanner;

/**
 * 注意特殊情况要予以特殊判定,否则用例可能不完全正确, 1 既不是素数也不是合数
 * 数论的简单结论: 如果到了Math.sqrt(a) 还不能整除a，后面的就肯定也不能了
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];

        // 获取数据
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        // 判断素数
        for (int each : arr) {
            if (Issushu(each) == 1) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    //译者注: 你这个方法名我要报警了
    //译者注: 正常的方法名为 isPrimeNumber
    public static int Issushu(int a) {
        if (a == 1) {
            return 0;
        }
        //译者注: 大小判断时不需要先进行类型转换
        for (int i = 2; i <= (int) Math.sqrt(a); i++) {
            if (a % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}
