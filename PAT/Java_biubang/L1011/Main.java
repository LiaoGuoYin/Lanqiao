package com.liaoguoyin.pat.团体程序设计天梯赛.L1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * L1-011 A-B （20 分）
 * <p>
 * 题目说了：保证每个字符串都是由可见的ASCII码和空白字符组成
 * czp: 这个问题时间限制只有 150ms, 就是来难为我 JVM 的
 * 只有状态好的时候，这个代码才可以AC，不知道那里还能优化..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();// A
        String s1 = bufferedReader.readLine();// B

        char[] chars = s.toCharArray();
        char[] chars1 = s1.toCharArray();

        StringBuilder stringBuilder = new StringBuilder("");

        for (int i = 0; i < chars.length; i++) {
            int flag = 1;
            for (int j = 0; j < chars1.length; j++) {
                if (chars[i] == chars1[j]) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                stringBuilder.append(chars[i]);
            }
        }
        System.out.println(stringBuilder);
    }
}