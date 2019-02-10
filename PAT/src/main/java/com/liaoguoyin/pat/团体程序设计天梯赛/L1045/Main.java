package com.liaoguoyin.pat.团体程序设计天梯赛.L1045;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * L1-045 宇宙无敌大招呼 （5 分）
 * 这道题证明了用 BufferedReader + InputStream 组合读入数据只需80ms+
 * 用 Scanner 要用110ms+
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();

        System.out.format("Hello %s", string);
    }
}
