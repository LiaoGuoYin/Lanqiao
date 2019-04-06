package com.liaoguoyin.pat.团体程序设计天梯赛.L1009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * L1-009 N个数求和 （20 分）
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(gcd(5, 22));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        List<String> stringList = new ArrayList<>(N);

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        while (stringTokenizer.hasMoreTokens()) {
            stringList.add(stringTokenizer.nextToken());
        }


        System.out.println(N);
        System.out.println(stringList);

    }

    static int gcd(int a, int b) {
        int k = 1;

        while (k != 0) {
            k = a % b;
            a = b;
            b = k;
        }

        return b;
    }
}