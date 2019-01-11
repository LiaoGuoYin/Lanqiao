import java.util.Scanner;

public class B1 {
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
// 因为oj主类是Main,然后我很瓜皮的把main方法也写成Main了..
// 复习了一下下逻辑运算符 & | ! ^ && ||
// && 还是& 一个叫短路与,一个叫长路与,区别在于第一个操作false之后是否执行第二个运算单元,短路与&&更偷懒 |和||同理
// 刚刚用了下,发现还有点绕System.out.println( i== 0 | i++==3 );记住|和& 长路或与 都执行就好拉
// 刚刚发现一个逻辑运算符很好的例题,搬过来:
// int i = 1;
// boolean b = !(i++ == 3) ^ (i++ ==2) && (i++==3);
// System.out.println(b);
// System.out.println(i);
