package com.liaoguoyin.pat.团体程序设计天梯赛.L1055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * L1-055 谁是赢家 （10 分）
 * <p>
 * 情况考虑全就好了，很常规的考if语句
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String audience = bufferedReader.readLine();
        String judge = bufferedReader.readLine();

        int audienceA = Integer.parseInt(audience.split(" ")[0]);
        int audienceB = Integer.parseInt(audience.split(" ")[1]);
        int judgeA = 0;
        int judgeB = 0;

        // 计算 A、B 评委得分
        for (int i = 0; i < 3; i++) {
            if (judge.split(" ")[i].equals("1")) {
                judgeB++;
            } else {
                judgeA++;
            }
        }

        // 判断比分结果
        if (judgeA == 3 || (audienceA > audienceB && judgeA > 0)) {
            System.out.format("The winner is a: %d + %d", audienceA, judgeA);
        }
        if (judgeB == 3 || (audienceA < audienceB && judgeB > 0)) {
            System.out.format("The winner is b: %d + %d", audienceB, judgeB);
        }

    }
}
