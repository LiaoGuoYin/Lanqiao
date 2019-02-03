package com.liaoguoyin.pat.团体程序设计天梯赛.L1007;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * L1-007 念数字 （10 分）
 * <p>
 * 编码问题，第一次做这个题的时候，用 swtich 很笨的解决了这题，后来才知道有 Map 这种东西存在
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Map<Character, String> map = new HashMap<>();

        map.put('-', "fu");
        map.put('0', "ling");
        map.put('1', "yi");
        map.put('2', "er");
        map.put('3', "san");
        map.put('4', "si");
        map.put('5', "wu");
        map.put('6', "liu");
        map.put('7', "qi");
        map.put('8', "ba");
        map.put('9', "jiu");

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            System.out.printf("%s ", map.get(chars[i]));
        }
        System.out.print(map.get(chars[chars.length - 1]));
    }
}
