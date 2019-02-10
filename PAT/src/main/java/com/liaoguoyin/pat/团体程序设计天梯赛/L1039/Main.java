package com.liaoguoyin.pat.团体程序设计天梯赛.L1039;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * L1-039 古风排版 （20 分）
 * <p>
 * TODO 还没做对..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());// 每列有N个字符
        String s = bufferedReader.readLine();
        char[] chars = s.toCharArray();
        int line = (s.length() / N) + 1;

        try {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < line; j++) {
                    System.out.print(chars[j * 4 + i]);
                }
                System.out.println();
            }
        } catch (Exception ArrayIndexOutOfBoundsException) {
            System.out.print(" ");
        }

    }
}
