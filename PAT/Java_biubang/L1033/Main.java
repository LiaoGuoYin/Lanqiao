

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 用HashSet 非常nice, set.size()即是年份里面不同的数字个数
 * //译者注: 如果需要写入很多次而只读取一次, 应使用 LinkedHashSet (LinkedList, LinkedMap 这种 Link 开头的表示里面是一个链表)
 * //译者注: 有关多写少读, 多读少写, 多读多写, 差异性数据, 同质化数据, 海量数据索引等等问题详见 数据结构概论
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int initYear = year;// 复制一个初始年份
        int n = scanner.nextInt();

        for (int i = 0; diffDigit(year) != n; i++) {
            year++;
            diffDigit(year);
        }// year自增找到满足条件的year

        System.out.format("%d %04d", (year - initYear), year);// 格式化输出

    }

    public static int diffDigit(int a) {
        String str = String.format("%04d", a);
        char[] arr = str.toCharArray();
        Set<Integer> arrSet = new HashSet<>();

        for (char each : arr) {
            arrSet.add(Integer.parseInt(Character.toString(each)));
        } // 遍历数组存入set集合中

        return arrSet.size();
    }
}
