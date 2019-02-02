

import java.util.Scanner;

/**
 * //译者注: 位运算在高级语言尽可能少的使用. 因为高级语言可能会对基本的数学运算和数据存储进行封装, 导致位运算出现与预期不符的结果(Java 的位运算没有特别大的坑).
 * //译者注: 此问题在动态类型语言尤其严重, 所以高级语言的位运算只需了解即可.
 * //译者注: 如需深刻理解位运算可以在 c语言 中尝试.
 * 因为oj主类是Main,然后我很瓜皮的把main方法也写成Main了..
 * 复习了一下下逻辑运算符 & | ! ^ && ||
 * && 还是& 一个叫短路与,一个叫长路与,区别在于第一个操作false之后是否执行第二个运算单元,短路与&&更偷懒 |和||同理
 * 刚刚用了下,发现还有点绕System.out.println( i== 0 | i++==3 );记住|和& 长路或与 都执行就好拉
 * 刚刚发现一个逻辑运算符很好的例题,搬过来:
 * int i = 1;
 * boolean b = !(i++ == 3) ^ (i++ ==2) && (i++==3);
 * System.out.println(b);
 * System.out.println(i);
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        int year = sc1.nextInt();

        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
