import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// L1-023 输出GPLT 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		// Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		String str = scanner.readLine();
		char[] arr = str.toCharArray();

		int[] count = new int[4];
		for (char each : arr) {
			if (each == 'g' || each == 'G')
				count[0]++;
			if (each == 'p' || each == 'P')
				count[1]++;
			if (each == 'l' || each == 'L')
				count[2]++;
			if (each == 't' || each == 'T')
				count[3]++;
		}

		// 出现最多的字母次数(循环次数)
		int max = Math.max(count[0], Math.max(count[1], Math.max(count[2], count[3])));

		// 输出
		for (int i = 0; i < max; i++) {
			if (count[0] != 0) {
				System.out.print("G");
				count[0]--;
			}
			if (count[1] != 0) {
				System.out.print("P");
				count[1]--;
			}
			if (count[2] != 0) {
				System.out.print("L");
				count[2]--;
			}
			if (count[3] != 0) {
				System.out.print("T");
				count[3]--;
			}
		}
	}
}
// 他大爷的tle(Time limited Exceed) 看来以后不能用Scanner了
//     解决输入读入时间长的几种解决方案:
// 	    1. 把scanner.nextInt()转为 Integer.parseInt(scanner.next()) 这里减少了正则匹配int的时间
//      2. new Scanner(new BufferedInputStream(System.in)); 这里增加了一个缓冲区，能进一步好一点
//      3. 究级Reader法,可能比c的scanf还要快,快得一皮 80ms左右
//         BufferedReader bd = new BufferedReader(new InputStreamReader(System.in))
// GPLT: Group Programming Ladder Tournament