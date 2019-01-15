package practice;

//L1-013 计算阶乘和 （10 分）
//对于给定的正整数N，需要你计算 S=1!+2!+3!+...+N!。
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		scanner.close();

		int S = 0;
		for (int i = 1; i <= N; i++) {
			int k = 1;
			for (int j = i; j > 0; j--) {
				k = k * j;
			}
			S = S + k;
		}

		System.out.println(S);
	}
}
// 本以为这是个很简单的问题。。但是被自己复杂化了，其实回过头看，分俩步：
// 			1. 求1！～N！的和     2. 求每一个i！的值，这里自减迭代自身
// 另外，有点服这种解法...
// String[] factorials = new String[]{
// "1",
// "1",
// "3",
// "9",
// "37",
// "169",
// "981",
// "6429",
// "49669",
// "430861",
// "4208925",
// "45345165",
// "536229373",
// "6884917597",
// "95473049469",
// "1420609412637",
// "22580588347741",
// "381713065286173"
// };