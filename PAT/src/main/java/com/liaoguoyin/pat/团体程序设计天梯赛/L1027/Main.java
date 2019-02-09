package com.liaoguoyin.pat.团体程序设计天梯赛.L1027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * L1-027 出租 （20 分）
 * <p>
 * arr 用set储存且降序输出；
 * BufferedReader + InputStreamReader 读取100ms内完事，太酸爽了：
 *      bufferedreader.read()读取单个字符
 *      bufferedreader.readLine()一个文本行
 * StringBuffer类似与一个字符串缓冲区，是不可变字符，同步
 * StringBuilder 不同步，更快，是一个可变的字符串序列
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        char[] phoneArr = line.toCharArray();
        Set<Integer> set = new HashSet<>();

        // 获取所有数字Set 和电话单个数字Array
        int[] phoneNumber = new int[11];
        for (int i = 0; i < 11; i++) {
            phoneNumber[i] = Character.getNumericValue(phoneArr[i]);
            set.add(phoneNumber[i]);
        }

        // 数字Set 转换为 数字Array
        int[] arr = new int[set.size()];
        int i = set.size() - 1;
        for (Integer each : set) {
            arr[i] = each;
            i--;
        }

        // 得到 index位置数组
        int[] index = new int[11];
        for (int j = 0; j < 11; j++) {
            index[j] = indexTmp(phoneNumber[j], arr);
        }

        // 输出
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < arr.length; j++) {
            stringBuilder.append(arr[j]);
            if (j != arr.length - 1) {
                stringBuilder.append(",");
            }
        }
        System.out.format("int[] arr = new int[]{%s};%n", stringBuilder);

        StringBuilder stringBuilder2 = new StringBuilder();
        for (int j = 0; j < index.length; j++) {
            stringBuilder2.append(index[j]);
            if (j != index.length - 1) {
                stringBuilder2.append(",");
            }
        }
        System.out.format("int[] index = new int[]{%s};", stringBuilder2);

    }

    // 获取tmp在arr[]里面的位置location
    public static int indexTmp(int tmp, int[] arr) {
        int location = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == tmp) {
                location = i;
                break;
            }
        }
        return location;
    }
}
