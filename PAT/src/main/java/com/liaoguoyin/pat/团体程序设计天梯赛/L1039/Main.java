package com.liaoguoyin.pat.团体程序设计天梯赛.L1039;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * L1-039 古风排版 （20 分）
 * <p>
 * 一步一步的分解问题：读入数据-数据预处理-数据转换-数据格式输出
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());// 每列有N个字符

        StringBuilder s = new StringBuilder(bufferedReader.readLine());
        while (s.length() % N != 0) {
            s.append(" ");
        }
        char[] chars = s.toString().toCharArray();

        // 计算行数
        int column = s.length() / N;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(chars[s.toString().length() - ((j + 1) * N) + i]);
            }
            System.out.println();
        }
    }
}
