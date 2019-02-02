

import java.util.Scanner;

/**
 * 思路一：比较简单，所有的x转 10进制都可以这么转，result = 各个位的系数*x的（位序列-1）次方 求和；
 * 当然，思路二：也可以直接用工具类函数Long.toString(a,16);
 * 注意做题的时候，要先 粗估最值 来选取合适的数据类型
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 获取字符串的每一位,指数为 a.length-j-1
        char[] a = scanner.nextLine().toCharArray();
        scanner.close();

        long a_integer = 0;

        for (int j = 0; j < a.length; j++) {
            int a_xs = 0;

            if (a[j] >= '0' && a[j] <= '9') {
                a_xs = a[j] - '0';
            } else {
                a_xs = a[j] - 'A' + 10;
            }

            a_integer = (int) (a_integer + a_xs * Math.pow(16, a.length - j - 1));
        }
        System.out.println(a_integer);
    }
}
