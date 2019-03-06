package com.liaoguoyin.IndexBuild;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 遍历目录，寻找 *.kt 和 *.java
 * 生成相对路径目录的markdown表格文件
 */

public class IndexAll {
    private static ArrayList<String> javaList;
    private static ArrayList<String> kotlinList;

    private static void iteratorPath(String dir) throws UnsupportedEncodingException {
        File[] files = new File(dir).listFiles();

        assert files != null;
        for (File each : files) {
            if (each != null) {
                if (each.isDirectory()) {
                    iteratorPath(each.getPath());
                } else if (each.isFile()) {

                    if (each.getName().endsWith(".java")) {
                        String[] partPath = each.getPath().split("/");
                        String eachLine = String.format("| [%s](%s) |", partPath[partPath.length - 2], urlencode(each.getPath().substring(2)));
                        javaList.add(eachLine);
                    } else if (each.getName().endsWith(".kt")) {
                        String name = each.getName();
                        String title = name.substring(7, name.length() - 3);
                        String id = name.substring(0, 6);
                        String eachLine = String.format("| [%s-%s](%s) |", id, title, urlencode(each.getPath().substring(2)));
                        kotlinList.add(eachLine);
                    }

                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File output = new File("output.md");// 输出结果到rootProject/output.md
        // FileWriter fileWriter = new FileWriter(output, false);// 追加输出到文件
        PrintWriter printWriter = new PrintWriter(output);
        javaList = new ArrayList<>();
        kotlinList = new ArrayList<>();
        iteratorPath(".");// 递归遍历

        Object[] javaLists = javaList.toArray();
        Object[] kotlinLists = kotlinList.toArray();
        Arrays.sort(javaLists);// 按照名称排序
        Arrays.sort(kotlinLists);

        // 输出
        printWriter.println("| 目录索引 |");
        printWriter.println("| :---- |");
        for (Object each : javaLists) {
            printWriter.println(each.toString());
            System.out.println("正在输出：" + each.toString());
        }
        for (Object each : kotlinLists) {
            printWriter.println(each.toString());
            System.out.println("正在输出：" + each.toString());
        }
        printWriter.close();
        System.out.println("output success!!");
    }

    /**
     * URLEncode会将空格编码为"+"，而当空格不在表单和查询字符串中，却位于URI中的时候（协议规定冲突）：空格的编码应该是%20
     * 又把 / 转义回去是因为: %2F太难看了
     *
     * @param string
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String urlencode(String string) throws UnsupportedEncodingException {
        return URLEncoder.encode(string, "UTF-8").replaceAll("\\+", "%20").replaceAll("%2F", "/");
    }
}
