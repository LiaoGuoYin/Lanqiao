package com.liaoguoyin.pat.团体程序设计天梯赛.L1032;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * L1-032 Left-pad （20 分）
 * <p>
 * 总觉得这个题可以用"队列"的思想 ，但是还是用了比较猥琐的 substring（）TODO
 * 其实这里也可以用try catch 输出前缀字符，而不用if，简单又暴力
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String s1 = bufferedReader.readLine();

        String symbol = s.split(" ")[1];// 读取操作字符串
        int length = Integer.parseInt(s.split(" ")[0]);// result长度
        int gapLength = length - s1.length();// 截取字段长度

        if (gapLength >= 0) {
            for (int i = 0; i < gapLength; i++) {
                System.out.print(symbol);
            }
            System.out.println(s1);
        } else {
            String s2 = s1.substring(-gapLength, s1.length());
            System.out.println(s2);
        }
    }
}
