package com.liaoguoyin.pat.团体程序设计天梯赛.L1047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * L1-047 装睡 （10 分）
 * <p>
 * 如果其至少一项指标不在正常范围内，则输出其名字，每个名字占一行。
 * 考察if语句和数据的读取，很常见..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(bufferedReader.readLine());
        String[] strings = new String[i];

        // 读入每一行数据
        for (int j = 0; j < strings.length; j++) {
            strings[j] = bufferedReader.readLine();
        }

        // 处理数据
        String[] strings1 = new String[3];// String1用来临时储存每一个人的信息
        for (int j = 0; j < strings.length; j++) {
            strings1[0] = strings[j].split(" ")[0];
            strings1[1] = strings[j].split(" ")[1];
            strings1[2] = strings[j].split(" ")[2];
            if (check(strings1[1], strings1[2]) == 1) {
                System.out.println(strings1[0]);
            }
        }
    }

    public static int check(String breath, String pulse) {
        if (Integer.parseInt(breath) >= 15 && Integer.parseInt(breath) <= 20) {
            if (Integer.parseInt(pulse) >= 50 && Integer.parseInt(pulse) <= 70) {
                return 0;
            }
        }
        return 1;
    }
}
