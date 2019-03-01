package com.liaoguoyin.pat.团体程序设计天梯赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Floyd 求解"多源最短路径"（非负环图）：
 * 思路: 如果要让任意俩点（顶点a到顶点b）之间的路程变短，只能引入第三个点（顶点k），并通过顶点k中转即 a->k->b，才有可能缩短顶点a到顶点b的路程
 * 实现: 有关图论的问题，首先当然要存储下各条边，一般用邻接矩阵来存储;初始化填入各条边的权重之后，那么遍历比较ints[i][j] 和 ints[i][k] +ints[k][j]的大小，就能得到最短路径矩阵
 * （思路很简单，但是要注意：放行的顶点k，要放在循坏的最外层，放在里面遍历是可能不彻底的）
 * reference: http://wiki.jikexueyuan.com/project/easy-learn-algorithm/floyd.html
 *
 * demo data:
 * 4 8
 * 1 2 2
 * 1 3 6
 * 1 4 4
 * 2 3 3
 * 3 1 7
 * 3 4 1
 * 4 1 5
 * 4 3 12
 */
public class Floyd {
    public static void main(String[] args) throws IOException {
        // 读入所有数据
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        int n = Integer.parseInt(line.split(" ")[0]);// 顶点数n
        int m = Integer.parseInt(line.split(" ")[1]);// 边数m

        // 存入每条边数值
        String[] strings = new String[m];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = bufferedReader.readLine();
        }

        // 邻接矩阵初始化
        int inf = 999;// infinity无限的，可以提前估计一下
        int[][] ints = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    ints[i][j] = 0;
                } else {
                    ints[i][j] = inf;
                }
            }
        }

        // 存入边信息
        for (int i = 0; i < strings.length; i++) {
            int row = Integer.parseInt(strings[i].split(" ")[0]);
            int column = Integer.parseInt(strings[i].split(" ")[1]);
            ints[row - 1][column - 1] = Integer.parseInt(strings[i].split(" ")[2]);
        }

        // Floyd算法优化
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (ints[i][j] > ints[i][k] + ints[k][j]) {
                        ints[i][j] = ints[i][k] + ints[k][j];
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
    }
}
