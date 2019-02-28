package com.liaoguoyin.pat.团体程序设计天梯赛.L1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashMap;

/**
 * L1-043 阅览室 （20 分）
 * 要抛弃固定观念：先读取所有数据，再挨个处理；
 * 注意每一天的数据处理完之后要全部清零；
 * 借的时候用hahsmap存储借阅的数据，还的时候get数据并操作当前时间
 * 测试点24挂了?? TODO
 * <p>
 * 几个四舍五入的方法ceil round floor
 */

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int day = Integer.parseInt(bufferedReader.readLine());
        HashMap<Integer, String> hashMap = new HashMap<>();

        int currentDay = 0;
        int borrowCount = 0;
        int averageTime;
        int persistentTime = 0;

        while (currentDay < day) {
            String tmp = bufferedReader.readLine();

            // 解析上面读入的借阅数据
            int bookId = Integer.parseInt(tmp.split(" ")[0]);
            String status = tmp.split(" ")[1];
            String tmpTime = tmp.split(" ")[2];


            if (bookId == 0) {// 如果是0，则今天结束
                if (borrowCount == 0) {
                    averageTime = 0;
                } else {
                    averageTime = (int) (Math.ceil((persistentTime * 1.0) / borrowCount));
                }
                System.out.format("%d %d%n", borrowCount, averageTime);
                currentDay++;

                // 清空数据
                hashMap.clear();
                borrowCount = 0;
                persistentTime = 0;

            } else {// 如果非0，则录入借阅数据

                if ("S".equals(status)) {
                    // 借书
                    String startTime = tmp.split(" ")[2];
                    hashMap.put(bookId, tmpTime);
                } else {
                    // 还书
                    String startTime = hashMap.get(bookId);
                    if (null != startTime) {
                        int endHour = Integer.parseInt(tmp.split(" ")[2].split(":")[0]);
                        int endMin = Integer.parseInt(tmp.split(" ")[2].split(":")[1]);
                        int startHour = Integer.parseInt(startTime.split(":")[0]);
                        int startMin = Integer.parseInt(startTime.split(":")[1]);
                        persistentTime += (endHour - startHour) * 60 + (endMin - startMin);
                        borrowCount++;
                    }
                }

            }
        }
    }
}