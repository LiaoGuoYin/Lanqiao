package com.liaoguoyin.pat.团体程序设计天梯赛.L1025;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * // 异常的捕捉
 * // 题目太尼玛坑了，第二个字符串可能是"21 34 " 注意有个空格，第二个数据应该是 ？
 * // 如何只匹配一次？ 用String.split(" ",2);可以得到[21, 34 ]
 * // 原有的方法不够实用的时候可以去看一下源码，或许会有新的发现！！
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();


        String A = "?", B = "?";
        int AA = 99999, BB = 99999;
        try {
            AA = Integer.parseInt(str.split(" ", 2)[0]);

            if (AA >= 1 && AA <= 1000)
                A = str.split(" ")[0];
        } catch (Exception e) {
        }

        try {
            BB = Integer.parseInt(str.split(" ", 2)[1]);
            if (BB >= 1 && BB <= 1000)
                B = str.split(" ")[1];
        } catch (Exception e) {
        }

        if (A.equals("?") || B.equals("?"))
            System.out.format("%s + %s = ?", A, B);
        else
            System.out.format("%d + %d = %d", AA, BB, (AA + BB));

    }
}