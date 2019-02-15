package com.liaoguoyin.pat.团体程序设计天梯赛.L1046;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * L1-046 整除光棍 （20 分）
 * <p>
 * 测试点的数据足够恶星星。这题必须用大数类 new BigInteger（String str）
 * 大数类 mod 取余，注意比较内容是否相同用equals()；这里可以 toString() 比较内容也可以 比较new BigInteger("0")
 * 思路二：用StringBuilder 来生成1、11、111、1111... 然后遍历（这个办法没想明白测试点1无法通过？？）
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger dividend = new BigInteger(bufferedReader.readLine());// 读入一定是奇数并且不以5结尾的整数x.
        BigInteger x = new BigInteger("0");

        // BigInteger.mod 取余找到合适光棍数
        for (int i = 0; ; i++) {
            x = x.add(new BigInteger("1"));
            if (x.mod(dividend).toString().equals("0")) {
                System.out.format("%d %d", x.divide(dividend), i + 1);
                break;
            }
            x = x.multiply(new BigInteger("10"));
        }

    }
}
