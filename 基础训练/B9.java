import java.util.Scanner;

public class B9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int g, s, b, q, w, sw;
		int n = scanner.nextInt();
		scanner.close();

		for (int i = 10000; i < 1000000; i++) {
			g = i % 10;
			s = (i % 100) / 10;
			b = (i % 1000) / 100;
			q = (i % 10000) / 1000;
			w = (i % 100000) / 10000;
			sw = i / 100000;
			if (g == sw && s == w && b == q && sw != 0 && n == g + s + b + q + w + sw) {
				System.out.println(i);
			} else if (g == w && s == q && sw == 0 && n == g + s + b + q + w) {
				System.out.println(i);
			}
		}

	}
}
// 注意对5位数字和6位数字的情况, 限定条件要写齐全!