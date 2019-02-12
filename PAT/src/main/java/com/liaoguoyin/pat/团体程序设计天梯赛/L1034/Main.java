package com.liaoguoyin.pat.团体程序设计天梯赛.L1034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * L1-034 点赞 （20 分）
 * <p>
 * 数据的存储关系到 统计关键字的次数，那么必然用到 Map
 * 兴致冲冲的写下来，最后才发现：如果有并列，则输出编号最大的那个。
 * 这样一来的话，思路就是：读取存储所有数据，再sort（）处理，最后遍历找最大
 * 测试点四 TLE 了... TODO
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(bufferedReader.readLine());// 读入接下来要输入的数据行数i

        // 读入所有数据到 stringBuilder
        StringBuilder stringBuilder = new StringBuilder("");
        for (int j = 0; j < i; j++) {
            String tmp = bufferedReader.readLine();
            String[] strings = tmp.split(" ");
            for (int k = 1; k < strings.length; k++) {
                stringBuilder.append(strings[k]).append(" ");
            }
        }

        // 拼接数据
        String[] strings = stringBuilder.toString().split(" ");
        int[] ints = new int[strings.length];
        for (int j = 0; j < strings.length; j++) {
            ints[j] = Integer.parseInt(strings[j]);
        }

        Arrays.sort(ints);
        // System.out.println(Arrays.toString(ints));

        // 找最大计数 & 最大数
        int maxCount = 0;
        int max = 0;
        for (int anInt1 : ints) {
            int count = 0;
            for (int anInt : ints) {
                if (anInt1 == anInt) {
                    count++;
                    if (maxCount <= count) {
                        max = anInt1;
                        maxCount = count;
                    }
                }
            }
        }
        System.out.format("%d %d", max, maxCount);
    }
}