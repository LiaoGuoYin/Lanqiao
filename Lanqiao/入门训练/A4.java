//Fobinacci数列
import java.util.Scanner;

public class A4 {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		int n = sc1.nextInt();
		sc1.close();

		long[] F = new long[n + 2];
		F[1] = F[2] = 1;
		for (int i = 3; i <= n; i++) {
			F[i] = (F[i - 1] + F[i - 2]) % 10007;
		}

		System.out.print(F[n]);
	}
}

// 法二：
public class A4_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		long[] window = new long[] { 1, 1, 0 };

		// 处理前两个斐波那楔数
		if (n == 1) {
			System.out.println("1");
		}
		if (n == 2) {
			System.out.println("1 1");
		}

		for (int i = 3; i <= n; i++) {
			window[2] = window[0] + window[1];
			System.out.print(" " + window[2]);

			window[0] = window[1];
			window[1] = window[2];
		}
	}
}
// 错了好几次,全在数组越界上，这个得注意..
// 法二是真的牛皮，窗口滑动的思想，就只取局部的3个窗口，用偏移的方法节省了空间 666
