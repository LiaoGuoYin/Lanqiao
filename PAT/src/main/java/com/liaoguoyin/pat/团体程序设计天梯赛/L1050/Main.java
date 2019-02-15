package com.liaoguoyin.pat.团体程序设计天梯赛.L1050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * L1-050 倒数第N个字符串 （15 分）
 * <p>
 * 看了吃猪皮老哥的解析确信是进制数的感觉：
 * 题目要求的倒数第 N 个，其实就是L位的26进制数的第 26^L-N 个
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String tmp = bufferedReader.readLine();
        int L = Integer.parseInt(tmp.split(" ")[0]);
        int N = Integer.parseInt(tmp.split(" ")[1]);

        // 计算对应的正向顺序N
        N = (int) Math.pow(26, L) - N;
        int[] ints = new int[L];

        // 取余，得每一位的值
        for (int i = 0; i < ints.length; i++) {
            ints[i] = N % 26;
            N = N / 26;
        }

        // 生成字符串
        StringBuilder stringBuilder = new StringBuilder();
        //System.out.println(Arrays.toString(ints));
        for (int anInt : ints) {
            char tmpint = (char) ('a' + anInt);
            stringBuilder.append(tmpint);
        }

        // 因为数组序列是从最后一位处理的，所以最后要反转字符串
        stringBuilder.reverse();
        System.out.println(stringBuilder.toString());
    }
}
