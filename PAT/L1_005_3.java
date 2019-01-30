import java.util.Arrays;
import java.util.Scanner;

public class L1_005_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();

		// 录入信息到数组
		String[] arr = new String[N];
		Long[][] data = new Long[N][3];
		scanner.nextLine();// 吸收换行符
		for (int i = 0; i < N; i++) {
			arr[i] = scanner.nextLine();
			data[i][0] = Long.parseLong(arr[i].split(" ")[0]);
			data[i][1] = Long.parseLong(arr[i].split(" ")[1]);
			data[i][2] = Long.parseLong(arr[i].split(" ")[2]);

		}

		// 输入查询信息(试机座位号码)
		int line = scanner.nextInt();
		scanner.nextLine();// 吸收换行符
		int[] chaxunTime = new int[line];
		for (int i = 0; i < chaxunTime.length; i++) {
			chaxunTime[i] = scanner.nextInt();
		}

		// 对成绩Data二维数组排序(冒泡bubleSort)
		long tmp = data[0][1];
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = 0; j < data.length - i - 1; j++) {
				if (data[j][1] > data[j + 1][1]) {
					tmp = data[j + 1][0];
					data[j + 1][0] = data[j][0];
					data[j][0] = tmp;
					tmp = data[j + 1][1];
					data[j + 1][1] = data[j][1];
					data[j][1] = tmp;
					tmp = data[j + 1][2];
					data[j + 1][2] = data[j][2];
					data[j][2] = tmp;
				}
			}
		}

		// 查询
		for (int j = 0; j < chaxunTime.length; j++) {
			System.out.println(data[chaxunTime[j] - 1][0] + " " + data[chaxunTime[j] - 1][2]);
		}
	}
}

// 2019-1-30又做了一遍，timeout了... TODO