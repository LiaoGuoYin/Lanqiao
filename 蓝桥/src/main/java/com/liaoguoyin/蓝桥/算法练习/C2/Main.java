package com.liaoguoyin.蓝桥.算法练习.C2;

import java.util.Scanner;

/**
 * //译者注: 当注释中有空行时, 格式化会自动补全空行为 <p>, 用于 JavaDoc 正确的生成
 * 要用到数论的结论：
 * 若三个数互为质数,那么这三个数的乘积便为它们的最小公倍数。
 * 从N展开，有以下俩种情况:
 * (1) 奇-偶-奇 当N为奇数时,那么 N,N-1,N-2 互为质数,很明显 N*N-1*N-2 是1~N最小公倍数的最大值。
 * (2) 偶-奇-偶 当N为偶数时,当N为偶数时,但不能被3整除时 N,N-1,N-3 互质,则 N*N-1*N-3 是最小公倍数的最大值；
 * 当N能被3整除时 N-1,N-2,N-3 互质,此时 N-1*N-2*N-3 是1~N最小公倍数的最大值；
 * <p>
 * 其实我在矛盾：为什么N为偶数且是3的倍数的情况下，最大公倍数是(N-1)*(N-2)*(N-3) 而不是N*(N-1)*(N-4)
 * 即把N-3变为N-4，一开始想的变换最小的？这样一来最大公倍数受影响程度最小？
 * 其实不然。这样做的话N-1和N-4的关系不得进一步商榷了吗，N-1是否为3的倍数，这里又要分情况讨论了，贪心算法里面的 马踏棋盘的深搜案例 告诉我们：
 * 每走一步，情况要越来越少才好，情况越来越多，回溯只会越来越复杂...
 * <p>
 * 做这种数论的问题，要多考虑最一般的情况，出来的解才会不重不漏
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();
        isok(n);
    }

    //译者注: 对于返回 Boolean 类型的方法, 命名应当形如 isOk()
    public static void isok(long n) {
        if (n <= 2) {
            System.out.println(n);
        } else {
            if (n % 2 != 0) {
                System.out.println(n * (n - 1) * (n - 2));
            } else {
                if (n % 3 == 0) {
                    System.out.println((n - 1) * (n - 2) * (n - 3));
                } else {
                    System.out.println(n * (n - 1) * (n - 3));
                }
            }
        }
    }
}
