package com.liaoguoyin.IndexBuild;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * 遍历目录，寻找 *.kt 和 *.java
 */

public class IteratorDir {
    static List<String> fileList = new ArrayList<>();
    static Map<String, File[]> map = new HashMap<>();// 存放不同路径父目录

    public static <map> void iteratorPath(String dir) throws UnsupportedEncodingException {
        File file = new File(dir);
        File[] files = file.listFiles();

        // 递归遍历目录
        if (files != null) {
            for (File each : files) {
                if (each.isDirectory()) {
                    iteratorPath(each.getPath());
                } else {
                    if (each.toString().endsWith(".java") || each.toString().endsWith(".kt")) {
                        String parentDir = each.getParent();
                        map.put(parentDir, new File(parentDir).listFiles());// 存放当前目录所有符合要求的文件
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        iteratorPath(".");
        for (String each : map.keySet()) {
            System.out.println(each);
        }

    }

    public static String urlencode(String s) throws UnsupportedEncodingException {
        return URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20").replaceAll("%2F", "/");
    }
}
