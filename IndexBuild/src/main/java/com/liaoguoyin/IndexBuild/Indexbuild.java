package com.liaoguoyin.IndexBuild;

import java.io.*;
import java.net.URLEncoder;
import java.util.Arrays;

public class Indexbuild {
    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter("./directoryIndex.txt", "UTF-8");
        File file = new File("PAT/src/main/kotlin/com/hiczp/pat/gplt");
        File[] files = file.listFiles();
        Arrays.sort(files);

        String[] id = new String[files.length];
        String[] title = new String[files.length];
        String[] javaPath = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            id[i] = files[i].getName().split(" ", 0)[0];
            title[i] = files[i].getName().split(" ", 0)[1].split("\\.kt")[0];// 匹配不完整，正则??TOdo
            javaPath[i] = String.format("PAT/src/main/java/com/liaoguoyin/pat/团体程序设计天梯赛/%s%s", id[i].split("-")[0], id[i].split("-")[1]);
            String result = String.format("| %s | %s | [Java](%s) | [Kotlin](%s) |%n", id[i], title[i], urlencode(javaPath[i]), urlencode(files[i].getPath()));

            // 输出到文件
            printWriter.print(result);
        }
        printWriter.close();
    }

    public static String urlencode(String s) throws UnsupportedEncodingException {
        return URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20").replaceAll("%2F", "/");
    }
}
