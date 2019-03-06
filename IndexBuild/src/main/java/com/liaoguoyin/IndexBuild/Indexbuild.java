package com.liaoguoyin.IndexBuild;

import java.io.*;
import java.net.URLEncoder;
import java.util.Arrays;

/**
 * 笨办法输入路径，生成索引目录
 */
public class Indexbuild {
    public static void main(String[] args) throws IOException {
        File file0 = new File("README.md");
        FileWriter fileWriter = new FileWriter(file0, true);//追加输出
        PrintWriter printWriter = new PrintWriter(fileWriter);

        File file = new File("PAT/src/main/kotlin/com/hiczp/pat/gplt");
        File[] files = file.listFiles();

        assert files != null;
        Arrays.sort(files);

        String[] id = new String[files.length];
        String[] title = new String[files.length];
        String[] javaPath = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            String tmp = files[i].getName();
            id[i] = tmp.substring(0, 6);
            title[i] = tmp.substring(7, tmp.length() - 3);
            javaPath[i] = String.format("PAT/src/main/java/com/liaoguoyin/pat/团体程序设计天梯赛/%s%s/Main.java", id[i].split("-")[0], id[i].split("-")[1]);
            String result = String.format("| %s | %s | [Java](%s) | [Kotlin](%s) |%n", id[i], title[i], urlencode(javaPath[i]), urlencode(files[i].getPath()));

            // 追加输出到READ.ME
            System.out.println(result);
            printWriter.print(result);
        }
        printWriter.close();
    }

    private static String urlencode(String s) throws UnsupportedEncodingException {
        return URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20").replaceAll("%2F", "/");
    }
}
