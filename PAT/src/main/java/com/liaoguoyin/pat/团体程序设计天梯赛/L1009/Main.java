package com.liaoguoyin.pat.团体程序设计天梯赛.L1009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * L1-009 N个数求和 （20 分）
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        List<String> stringList = new ArrayList<>(N);

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        while (stringTokenizer.hasMoreTokens()) {
            stringList.add(stringTokenizer.nextToken());
        }

        // 找分母set里面的最小公倍数
        Collections.sort(stringList, (o1, o2) -> Integer.parseInt(o1.split("/")[1]) - Integer.parseInt(o2.split("/")[1]));
        int common = maxCommonInt(Integer.parseInt(stringList.get(0).split("/")[1]), Integer.parseInt(stringList.get(1).split("/")[1]));
        System.out.println(stringList);
        System.out.println(common);
    }

    private static int maxCommonInt(int i, int j) {
        int k = 2;
        while (k * i <= j) {
            k++;
        }

        if (k * i == j) {
            return k;
        } else {
            return i * j;
        }

    }
}
