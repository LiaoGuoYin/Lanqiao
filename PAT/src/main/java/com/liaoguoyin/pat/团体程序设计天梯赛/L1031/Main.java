package com.liaoguoyin.pat.团体程序设计天梯赛.L1031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * L1-031 到底是不是太胖了 （10 分）
 * 如果代码的复用性很高，可以考虑用函数封装
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = bufferedReader.readLine();
        }

        for (String each : arr) {
            int height = Integer.parseInt(each.split(" ")[0]);
            int realWeight = Integer.parseInt(each.split(" ")[1]);
            isStd(height, realWeight);
        }

    }

    public static void isStd(int height, int realWeight) {
        double stdWeight = (height - 100) * 0.9 * 2;
        double gap = stdWeight - realWeight;

        if (Math.abs(gap) < stdWeight * 0.1)
            System.out.println("You are wan mei!");
        else if (gap > 0)
            System.out.println("You are tai shou le!");
        else if (gap < 0)
            System.out.println("You are tai pang le!");
    }
}
