package com.liaoguoyin.pat.团体程序设计天梯赛.L1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * L1-019 谁先倒 （15 分）
 * <p>
 * 细心读题：1）当达到酒量之后，还喝一杯，才会倒下.. 2）第二个输出的数据是没醉那个人喝了多少杯..
 * 数据的读取和存储：读入每一行line,split(" ")得到每一次的4项猜拳数据
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        int A = Integer.parseInt(s.split(" ")[0]);// A酒量
        int B = Integer.parseInt(s.split(" ")[1]);// B酒量
        int AA = A, BB = B;// 复制A、B酒量

        // 读取猜拳数据
        int N = Integer.parseInt(bufferedReader.readLine());
        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = bufferedReader.readLine();
        }

        // System.out.println(Arrays.toString(strings));// 调试查看输入数据是否正确
        int i = 0;
        while (A >= 0 && B >= 0) {
            int aYell = Integer.parseInt(strings[i].split(" ")[0]);
            int aDo = Integer.parseInt(strings[i].split(" ")[1]);
            int bYell = Integer.parseInt(strings[i].split(" ")[2]);
            int bDo = Integer.parseInt(strings[i].split(" ")[3]);
            if (aYell + bYell == aDo && aDo != bDo) {
                A--;
            } else if (aYell + bYell == bDo && bDo != aDo) {
                B--;
            }
            i++;
        }

        if (A < 0) {
            System.out.printf("A%n%s", BB - B);
        } else {
            System.out.printf("B%n%s", AA - A);
        }
    }
}
