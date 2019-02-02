

import java.util.Scanner;

/**
 * A+B问题
 * next()是以字段 截断    //译者注: next() 会一直读取直到下一个空格, 且获取不到空格本身(等于做了 trim())
 * nextInt()是遇到非 int 截断
 * nextLine()是遇到\r\n 截断 //译者注: 读取至下一个换行符
 * Scanner还可以这么用 int a = new java.util.Scanner(System.in).nextInt();同引入包中类的原理   //译者注: 这种写法除非类同名, 否则不要这么做, 将降低代码可读性
 * 注意复制到 oj 平台的话，要修改类的名字A1->Main    //译者注: IDE 中直接点击 Main 类左边的箭头即可运行
 * //译者注: IDEA 有很多快捷操作, 例如输入 psvm 即可获得 public static void main(String[] args). 同理还有 fori array stream
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        System.out.print(A + B);
    }
}
