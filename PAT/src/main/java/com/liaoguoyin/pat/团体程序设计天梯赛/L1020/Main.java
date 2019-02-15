package com.liaoguoyin.pat.团体程序设计天梯赛.L1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * L1-020 帅到没朋友 （20 分）
 * <p>
 * 看到吃猪皮老哥 kotlin 里面分割字段用了 StringToekenizer() ，猛然发现比 split（）和 regex 好用!!
 * （官方文档说为了兼容性保留下来，但是做 oj 这个用起来真的很舒服）那么后面都不用 split（）了
 * 这也证明还是要边做边看其他大鸟的做题思路，集思广益= =
 * 第四个测试点 TLE 了，服气 TODO
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // 读入并存储数据
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int line = Integer.parseInt(stringTokenizer.nextToken());
        Set<String> hashSet = new HashSet<>();
        for (int i = 0; i < line; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int linePerson = Integer.parseInt(stringTokenizer.nextToken());

            if (linePerson == 1) {
                continue;
            } else {
                for (int j = 0; j < linePerson; j++) {
                    hashSet.add(stringTokenizer.nextToken());
                }
            }
        }

        // 查询数据
        int searchInt = Integer.parseInt(bufferedReader.readLine());
        String[] strings = bufferedReader.readLine().split(" ");
        // 查询数据去重
        List<String> list = new ArrayList<>();
        for (String each : strings) {
            if (!list.contains(each)) {
                list.add(each);
            }
        }

        // 输出结果，flag 表示是否有满足条件的元素，isFirst 用于判断是否是第一个元素————打空格
        int flag = 0;
        int isFirst = 1;
        for (String each : list) {
            if (!hashSet.contains(each)) {
                if (isFirst != 1) {
                    System.out.print(" ");
                }
                System.out.print(each);
                isFirst = 0;
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("No one is handsome");
        }
    }
}
