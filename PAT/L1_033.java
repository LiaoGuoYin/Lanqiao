import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int year = scanner.nextInt();
		int initYear = year;// 复制一个初始年份
		int n = scanner.nextInt();

		for (int i = 0; diffDigit(year) != n; i++) {
			year++;
			diffDigit(year);
		}// year自增找到满足条件的year
		
		System.out.format("%d %04d", (year - initYear), year);// 格式化输出

	}

	public static int diffDigit(int a) {
		String str = String.format("%04d", a);
		char[] arr = str.toCharArray();
		Set<Integer> arrSet = new HashSet<>();

		for (char each : arr) {
			arrSet.add(Integer.parseInt(Character.toString(each)));
		} // 遍历数组存入set集合中

		return arrSet.size();
	}
}
// 用HashSet 非常nice, set.size()即是年份里面不同的数字个数
