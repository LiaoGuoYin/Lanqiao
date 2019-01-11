//圆的面积
import java.util.Scanner;

public class A3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int r = scanner.nextInt();
		scanner.close();
		double Area = Math.PI * r * r;
		System.out.printf("%.7f", Area);
	}
}
// new java.text.DecimalFormat("0.0000000").format(Area);
// 寻思着像上面这样解决小数点后7位的问题,杀鸡用宰牛刀了,格式化输出这个地方还得补...
// printf能用格式化输出,println居然不能,惊了..
// 补充一点print的知识：实名感谢czp老哥的指点:）
// 才知道 print 是最标准的输出语句，printf中 f 是format，println是print line也就是print+换行操作符
// 换行操作符在不同的操作系统下不尽相同 *nix是 \n macos是\r Windows是\r\n
// 而在java中，换行符由变量 "line.separator" 取得，不同的操作系统下的编译器不一样，所以对换行符的编译可能有一定的差异
// 这样一来，上次听同学说源代码传上linux编译跑出来行数不对的问题就算是找到原因了..