//圆的面积
import java.util.Scanner;

public class A3{
	public static void main(String[] args){
		Scanner sc1 = new Scanner(System.in);
		int r =sc1.nextInt();
		sc1.close();
		double Area = Math.PI*r*r;
		System.out.printf("%.7f",Area);
	}
}
// new java.text.DecimalFormat("0.0000000").format(Area);
//寻思着像上面这样解决小数点后7位的问题,杀鸡用宰牛刀了,格式化输出这个地方还得补...
//printf能用格式化输出,println居然不能,惊了..
//补充：后来才知道print是最原始的输出语句。f是format，ln是形似\n
