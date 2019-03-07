package com.liaoguoyin.pat.团体程序设计天梯赛.L2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


/**
 * L2-019 悄悄关注 （25 分）
 * 本来写得很舒服，stream操作真香，但是oj平台也太难为Jvm了吧，搞了.
 * 估计测试点的数据读完都不止150ms吧...
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String tmp = bufferedReader.readLine();
        // 读入关注用户

        int followingCount = Integer.parseInt(tmp.split(" ")[0]);
        Set<String> following = new HashSet<>(followingCount);
        for (int i = 0; i < followingCount; i++) {
            following.add(tmp.split(" ")[i + 1]);
        }


        Map<String, Integer> unfollowing = new HashMap<>();
        int sum = 0;
        int times = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < times; i++) {
            String line = bufferedReader.readLine();
            String id = line.split(" ")[0];
            int agreeCount = Integer.parseInt(line.split(" ")[1]);

            sum += agreeCount;
            if (!following.contains(id)) {
                unfollowing.put(id, agreeCount);
            }
        }

        int average = sum / times;// 平均点赞次数（作为截止条件）
//        System.out.println("following :" + following);
//        System.out.println("unfollowing :" + unfollowing);
//        System.out.println("averageCount is :" + average);

        List<String> list = unfollowing
                .entrySet()
                .stream()
                .filter(s -> s.getValue() > average)
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if (list.isEmpty()) {
            System.out.println("Bing Mei You");
        } else {
            list.forEach(System.out::println);
        }
    }
}