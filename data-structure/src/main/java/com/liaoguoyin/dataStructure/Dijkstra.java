package com.liaoguoyin.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Dijkstra 求解"单元最短路径"
 */
public class Dijkstra {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        int n = Integer.parseInt(line.split(" ")[0]);// 顶点数n
        int m = Integer.parseInt(line.split(" ")[1]);// 边数m

        int[][] ints = new int[n][n];// 构造邻接矩阵

        // 初始化邻接矩阵，i表示行，j表示列
        int inf = 999;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    ints[i][j] = 0;
                } else {
                    ints[i][j] = inf;
                }
            }
        }

        // 初始化初始值
        for (int i = 0; i < m; i++) {
            line = bufferedReader.readLine();
            int row = Integer.parseInt(line.split(" ")[0]) - 1;
            int column = Integer.parseInt(line.split(" ")[1]) - 1;
            int value = Integer.parseInt(line.split(" ")[2]);

            ints[row][column] = value;
        }

        // 以顶点1为起点的最短路
        int[] book = new int[n];// 记录元素是否是最短路上的元素
        int[] dis = new int[n];// dis数组记录最短路尝试的路径
        int min, mif = 999;
        int u = 0;
        // 初始化dis数组、book数组
        for (int i = 0; i < n; i++) {
            dis[i] = ints[1][i];
        }
        for (int i = 0; i < n; i++) {
            book[i] = 0;
        }
        book[1] = 1;

        // Dijkstra算法核心部分
        for (int i = 0; i < n; i++) {

            // 找到book非1的最短路对应顶点u
            min = mif;
            for (int j = 0; j < n; j++) {
                if (book[j] == 0 && dis[j] < min) {
                    min = dis[j];
                    u = j;
                }
            }
            book[u] = 1;

            // 判断顶点u是否是合适的点
            for (int j = 0; j < n; j++) {
                if (ints[u][j] < inf) {
                    if (dis[j] > dis[u] + ints[u][j]) {
                        dis[j] = dis[u] + ints[u][j];
                    }
                }
            }
        }

        // out
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("最短路：");
        for (int i = 0; i < n; i++) {
            System.out.print(dis[i] + " ");
        }

    }
}
