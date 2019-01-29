import java.util.Arrays;
import java.util.Scanner;

public class L1_005_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();

		// 录入信息到数组
		String[] arr = new String[N];
		String[][] arr_cj = new String[N][3];
		scanner.nextLine();// 吸收换行符
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextLine();
			arr_cj[i] = arr[i].split(" ");
		}

		// 输入查询信息(试机座位号码)
		scanner.next();
		scanner.nextLine();// 吸收换行符
		String str = scanner.nextLine();
		String[] chaxun = str.split(" ");

		// 查询
		for (int j = 0; j < chaxun.length; j++) {
			for (int i = 0; i < arr_cj.length; i++) {
				if (arr_cj[i][1].equals(chaxun[j])) {
					System.out.println(arr_cj[i][0] + " " + arr_cj[i][2]);
				}
			}
		}
	}
}

// 注意要吸收换行符，做这种题的时候没头绪很乱的时候一步一步的分块做，边做边调试，还得看获取到的数组一样与否
// 注意字符串数组和整型数组的值永远不可能相同，这点很细微，语法乍一看没毛病，但是很容易出错
// 方法一是用二维数组，比较常规