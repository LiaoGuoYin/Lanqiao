package com.liaoguoyin.pat.团体程序设计天梯赛.L1037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * L1-037 A除以B （10 分）
 * <p>
 * 注意除数或被除数要*1.0，否则：结果会只有整数部分
 * 输出上有格式化的讲究，分段表示，其他没啥..
 * 这里为了追求读取速度特意使用了 BufferedReader 而没有使用Scanner(Scanner用了很多时间去正则匹配）
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int divisor = Integer.parseInt(s.split(" ")[0]);
        int dividend = Integer.parseInt(s.split(" ")[1]);


        if (dividend < 0) {
            double result = divisor / (1.0 * dividend);
            System.out.format("%d/(%d)=%.2f", divisor, dividend, result);
        } else if (dividend == 0) {
            System.out.format("%d/0=Error", divisor, dividend);
        } else {
            double result = divisor / (1.0 * dividend);
            System.out.format("%d/%d=%.2f", divisor, dividend, result);
        }
    }
}
