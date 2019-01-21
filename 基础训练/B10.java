
import java.util.Scanner;

//10进制 -> 16进制
public class B10 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		scanner.close();

		int a_pre = a / 16;// 有多少个满16
		int a_tail = a % 16;// 16进制的最后一位

		int count = 0;
		if (a == 0) {
			count = 0;
		} else {
			count = (int) (Math.log(a) / Math.log(16));
		}

		int[] arr = new int[count];
		for (int i = 0; i < count; i++) {
			arr[i] = a_pre % 16;
			a_pre = a_pre / 16;
		}

		for (int i = count - 1; i >= 0; i--) {
			System.out.print(inttochar(arr[i]));
		}
		System.out.println(inttochar(a_tail));
		// System.out.println("最终结果: " + Integer.toHexString(a).toUpperCase());
	}

	public static char inttochar(int a) {
		char result = ' ';
		if (a > 9) {
			result = (char) ('A' + a - 10);
		} else {
			result = (char) ('0' + a);
		}
		return result;
	}
}
// 思路一：a%b 意味着有a相对于b有多少个落单（不大于b的基数）a/b 意味着a有多少完整的b个单位，而这里余下除不尽的数就是前面说的余数；
// 		  那么先把有多少个满16算出来，也就是n/16, 然后把满16按照16个为一个单位分离出来，依次得到16进制的每一位..
//  		  注意取0的坑...
//		  这里主要是体会进制、余数的内涵
// 思路二：一步到位，直接用Integer.toHexString(a);记得 toUpperCase()
