package com.liaoguoyin.pat.团体程序设计天梯赛.L1054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * L1-054 福到了 （15 分）
 * <p>
 * 直接把所有的字符合到 stringBuild 一行字符串里面，然后每N个换行反转输出
 * 当然这里用二维数组存数据也行，下面的解法稍微有点暴力了
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = bufferedReader.readLine();
        String symbol = firstLine.split(" ")[0];

        // 读入符号和行数
        int N = Integer.parseInt(firstLine.split(" ")[1]);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            stringBuilder.append(bufferedReader.readLine());
        }

        // 如果对称则输出提示语
        if (stringBuilder.reverse().toString().equals(stringBuilder.reverse().toString())) {
            System.out.println("bu yong dao le");
        }

        // 反转字符串
        stringBuilder.reverse();

        // 替换字符
        char[] chars = stringBuilder.toString().replace("@", symbol).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i % N == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(chars[i]);
        }
    }
}
