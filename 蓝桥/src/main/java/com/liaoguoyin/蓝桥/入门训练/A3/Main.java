package com.liaoguoyin.蓝桥.入门训练.A3;

import java.util.Scanner;

/**
 * 圆的面积
 * new java.text.DecimalFormat("0.0000000").format(Area);   //译者注: DecimalFormat 不要尝试使用格式化模板来构造, 因为当占位符的数量很多时会数不清楚. 应当使用 setMaximumFractionDigits(n) 来指定保留的小数位数
 * 寻思着像上面这样解决小数点后7位的问题,杀鸡用宰牛刀了,格式化输出这个地方还得补...
 * printf能用格式化输出,println居然不能,惊了..   //译者注: 此问题的解决方案是先用 printf 输出后, 再使用一次无参 println() 来输出换行
 * 补充一点print的知识：实名感谢czp老哥的指点:）
 * 才知道 print 是最标准的输出语句，printf中 f 是format，println是print line也就是print+换行操作符
 * 换行操作符在不同的操作系统下不尽相同 *nix是 \n macos是\r Windows是\r\n    //译者注: MacOS 分为 Classical Mac(IBM Power) 和现代 Mac(Intel X86), 他们的换行符不一样
 * 而在java中，换行符由变量 "line.separator" 取得，不同的操作系统下的编译器不一样，所以对换行符的编译可能有一定的差异 //译者注: 这不是编译时决定的而是运行时决定的
 * 这样一来，上次听同学说源代码传上linux编译跑出来行数不对的问题就算是找到原因了..
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        scanner.close();
        double Area = Math.PI * r * r;
        System.out.printf("%.7f", Area);
    }
}
