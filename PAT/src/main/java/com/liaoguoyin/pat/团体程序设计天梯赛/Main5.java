package com.liaoguoyin.pat.团体程序设计天梯赛;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Date api practice
public class Main5 {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws ParseException {
        // Date now = new Date();
        //
        // System.out.println(now);
        //
        // Date date2 = new Date(6000);
        // System.out.println("pass 6s :"+date2);
        //
        // System.out.println(now.getTime());
        //
        // System.out.println(new Date().getTime());
        //
        // System.out.println(System.currentTimeMillis());

        String day1 = "1970-01-01 00:00:00";
        String day2 = "2000-12-31 23:59:59";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");

        Date firstday = sdf.parse(day1);
        Date endday = sdf.parse(day2);

        // System.out.println("第一天：" + sdf.format(firstday));
        // System.out.println("最后一天：" + sdf.format(endday));

        // 生成10个随机日期, 并取出时间
        Date[] date = new Date[9];
        for (int i = 0; i < 9; i++) {
            long timetime = (long) (firstday.getTime() + (Math.random() - 1) * (firstday.getTime() - endday.getTime()));
            date[i] = new Date(timetime);
        }

        System.out.println("排序前得到的9个随机时间：");
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(sdf.format(date[i]) + "\t");
        }

        System.out.println("\n排序后的9个时间：");
        // 取Hours Minutes Seconds 排序
        for (int i = 0; i < date.length - 1; i++) {
            for (int j = i; j < date.length - 1; j++) {
                Date tmp = new Date();

                if (date[j].getHours() > date[j + 1].getHours()) {
                    tmp = date[j];
                    date[j] = date[j + 1];
                    date[j + 1] = tmp;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(sdf.format(date[i]) + "\t");
        }
    }
}
