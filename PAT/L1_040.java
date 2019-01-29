
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();

		// 读取数据
		String[] sex = new String[N];
		Double[] height = new Double[N];
		for (int i = 0; i < N; i++) {
			sex[i] = scanner.next();
			height[i] = scanner.nextDouble();
		}

		// 计算身高
		for (int i = 0; i < sex.length; i++) {
			calculate(sex[i], height[i]);
		}
		
	}
	// 传入性别和身高，计算配偶身高
	public static void calculate(String str, Double height) {
		if (str.equals("F")) {
			System.out.printf("%.2f%n", height * 1.09);
		} else if (str.equals("M")) {
			System.out.printf("%.2f%n", height / 1.09);
		}
	}
}
// 比较字符串内容相同与否：要使用 equals 不用 == 
// 这里因为输入的数据是很规范的，读取数据用的暴力法，实际上这种数据结构是很不规范的.. 