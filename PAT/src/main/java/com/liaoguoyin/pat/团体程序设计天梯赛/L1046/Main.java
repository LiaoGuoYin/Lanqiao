package com.liaoguoyin.pat.团体程序设计天梯赛.L1046;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * L1-046 整除光棍 （20 分）
 * <p>
 * 测试点的数据足够恶星星。这题必须用大数类 new BigInteger（String str）
 * 用StringBuilder 来生成1、11、111、1111...
 * 大数类的mod用来取余，很奇怪的是测试点2没有通过(似乎没有特殊点？？) TODO
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String x = bufferedReader.readLine();//读入一个一定是奇数并且不以5结尾的整数x.

        BigInteger[] bigInteger = new BigInteger[50];
        BigInteger dividend = new BigInteger(x);

        // 生成30位以内的光棍数
        StringBuilder stringBuilder = new StringBuilder("1");
        bigInteger[0] = new BigInteger("1");
        for (int i = 1; i < 50; i++) {
            stringBuilder.append("1");
            bigInteger[i] = new BigInteger(stringBuilder.toString());
        }

        // System.out.println("generate :" + Arrays.toString(bigInteger));

        // BigInteger.mod 取余找到合适光棍数
        for (int i = 0; i < bigInteger.length; i++) {
            if (bigInteger[i].mod(dividend).equals(new BigInteger("0"))) {
                System.out.format("%d %d", bigInteger[i].divide(dividend), i + 1);
                break;
            }
        }
    }
}
