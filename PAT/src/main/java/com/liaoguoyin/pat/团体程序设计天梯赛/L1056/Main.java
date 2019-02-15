package com.liaoguoyin.pat.团体程序设计天梯赛.L1056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * L1-056 猜数字 （20 分）
 * <p>
 * 因为数据很规整，所以用了俩个数组读取数据，话说这样做是不是有点不道义..
 * 思路二：Treemap Todo
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(bufferedReader.readLine());

        // 读取存取数据
        String[] name = new String[line];
        int[] ints = new int[line];
        int sum = 0;
        for (int i = 0; i < line; i++) {
            String tmp = bufferedReader.readLine();
            name[i] = tmp.split(" ")[0];
            ints[i] = Integer.parseInt(tmp.split(" ")[1]);
            sum = sum + ints[i];
        }

        // 每一个元素 - average 取绝对值，新数组里面值最小的即为所找值
        int average = (sum / ints.length) / 2;
        for (int i = 0; i < line; i++) {
            ints[i] = Math.abs(ints[i] - average);
        }

        System.out.format("%d %s", average, name[getMinIndex(ints)]);
    }

    // 获取数组里面最小元素的下标
    private static int getMinIndex(int[] ints) {
        int min = ints[0];
        int minIndex = 0;
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] < min) {
                min = ints[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
