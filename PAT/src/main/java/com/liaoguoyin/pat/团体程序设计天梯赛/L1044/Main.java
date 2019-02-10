package com.liaoguoyin.pat.团体程序设计天梯赛.L1044;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * L1-044 稳赢 （15 分）
 * <p>
 * 用动态数组 ArrayList 来存每一次的划拳数据，且不用最后一个 End 元素
 * K = 2 时，因为动态数组的元素是从0开始的，所以第2、5、8、11下标对应的元素是平局的情况， 由此得到 if 语句的条件：(i + 1) % (K + 1) == 0
 * 这题输入数据若用 Scanner ，测试点2肯定AC不了..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bufferedReader.readLine());// 每隔K次让一次

        ArrayList<String> list = new ArrayList<>();

        // 读取数据
        String string = bufferedReader.readLine();
        while (!"End".equals(string)) {
            list.add(string);
            string = bufferedReader.readLine();
        }
        list.add(string);

        // 处理每一次划拳,不处理 End 那个元素
        for (int i = 0; i < list.size() - 1; i++) {
            if ((i + 1) % (K + 1) == 0) {
                // 平局出一样
                System.out.println(list.get(i));
            } else {
                // 稳赢对着出
                win(list.get(i));
            }
        }
    }

    public static void win(String s) {
        switch (s) {
            case "ChuiZi":
                System.out.println("Bu");
                break;
            case "JianDao":
                System.out.println("ChuiZi");
                break;
            case "Bu":
                System.out.println("JianDao");
        }
    }
}
