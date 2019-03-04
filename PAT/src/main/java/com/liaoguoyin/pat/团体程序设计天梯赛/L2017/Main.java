package com.liaoguoyin.pat.团体程序设计天梯赛.L2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * L2-017 人以群分 （25 分）
 * 分偶数和计数俩种情况：
 * 偶数的话五五开不用说；
 * 奇数的话，外向型一定比内向型多一人；
 * 测试点2、3 TLE了，尝试着广读入数据都tle.
 * 得在读入数据上下功夫了,jVM就这样，没我了
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        String line = bufferedReader.readLine();
        int[] ints = new int[N];
        for (int i = 0; i < N; i++) {
            ints[i] = Integer.parseInt(line.split(" ")[i]);
        }

        Arrays.sort(ints);// 排序

        int[] ints1 = new int[N / 2];
        int[] ints2 = new int[N / 2];
        System.arraycopy(ints, 0, ints1, 0, N / 2);
        System.arraycopy(ints, N / 2, ints2, 0, N / 2);


        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < ints1.length; i++) {
            sum1 += ints1[i];
        }
        for (int i = 0; i < ints2.length; i++) {
            sum2 += ints2[i];
        }
        int result = Math.abs(sum1 - sum2);

        if (N % 2 == 0) {
            System.out.format("Outgoing #: %d%n" +
                    "Introverted #: %d%n" +
                    "Diff = %d", ints2.length, ints1.length, result);
        } else {
            System.out.format("Outgoing #: %d%n" +
                    "Introverted #: %d%n" +
                    "Diff = %d", ints2.length + 1, ints1.length, result + ints[ints.length - 1]);
        }

    }

}
