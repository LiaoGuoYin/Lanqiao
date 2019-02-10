package com.liaoguoyin.pat.团体程序设计天梯赛.L1035;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * L1-035 情人节 （15 分）
 * <p>
 * 因为输入的数据不固定，用ArrayList
 * 注意情况节点要考虑完整, 最后一个元素"." 要单独移除
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();

        // inputdata
        String string = " ";
        while (!".".equals(string)) {
            string = scanner.nextLine();
            arrayList.add(string);
        }
        arrayList.remove(arrayList.size() - 1);// 移除最后一个元素"."

        // outputdata
        // 吃猪皮(czp)老哥注: 从代码美观度上考虑, 任何 block 不与 if 在同一行的代码, block 都应该拥有花括号. 详见 阿里巴巴Java代码规范
        if (arrayList.size() <= 1) {
            System.out.print("Momo... No one is for you ...");
        } else if (arrayList.size() <= 13) {
            System.out.format("%s is the only one for you...", arrayList.get(1));
        } else {
            System.out.format("%s and %s are inviting you to dinner...", arrayList.get(1), arrayList.get(13));
        }
    }
}
