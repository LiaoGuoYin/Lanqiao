package com.liaoguoyin.pat.团体程序设计天梯赛.L2005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * L2-005 集合相似度 （25 分）
 * 测试点3、4TLE 摊手.jpg
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());// 接下来N行读入集合
        StringTokenizer stringTokenizer;

        List<setList> lists = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int capacity = Integer.parseInt(stringTokenizer.nextToken());// 获取每一个集合的大小
            HashSet set = new HashSet(capacity);
            for (int j = 0; j < capacity; j++) {
                set.add(stringTokenizer.nextToken());
            }
            lists.add(new setList(set, N));

        }

//        System.out.println("all set is : ");
//
//        for (setList each : lists) {
//            System.out.println(each.set);
//        }

        // 输入查询信息
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int unchecking = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < unchecking; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken()) - 1;// lists是以0开始的
            int b = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            setList aSet = lists.get(a);
            setList bSet = lists.get(b);

            Set sumSet = new HashSet(aSet.set);
            sumSet.addAll(bSet.set);
            int samelength = aSet.length() + bSet.length() - sumSet.size();
            int aOut = aSet.length() - samelength;
            int bOut = bSet.length() - samelength;
            int Nc = aOut + bOut;

            System.out.format("%.2f%%%n", (100 - (Nc * 100.0) / sumSet.size()));
        }

    }
}

class setList {
    public Set set;
    private int id;

    setList(Set set, int id) {
        this.set = set;
        this.id = id;
    }

    int length() {
        return set.size();
    }
}